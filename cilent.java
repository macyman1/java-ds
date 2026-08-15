import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class cilent {
	private static final int PORT = 5000;

	public static void main(String[] args) {
		if (args.length == 0) {
			printUsage();
			return;
		}

		String mode = args[0].toLowerCase();
		if ("server".equals(mode)) {
			runServer();
		} else if ("client".equals(mode)) {
			runClient();
		} else {
			printUsage();
		}
	}

	private static void runServer() {
		System.out.println("Server starting on port " + PORT + "...");

		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Waiting for client connection...");

			try (Socket socket = serverSocket.accept();
				 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

				System.out.println("Client connected: " + socket.getInetAddress());
				out.println("Hello client, connected successfully");
				System.out.println("Sent greeting to client.");

				while (true) {
					String message = in.readLine();
					if (message == null) {
						System.out.println("Client disconnected.");
						break;
					}

					System.out.println("Received from client: " + message);
					out.println("Echo: " + message);

					if ("exit".equalsIgnoreCase(message)) {
						System.out.println("Closing server session.");
						break;
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Server error: " + e.getMessage());
		}
	}

	private static void runClient() {
		String host = "localhost";

		try (
			Socket socket = new Socket(host, PORT);
			BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in))
		) {
			String greeting = serverIn.readLine();
			if (greeting != null) {
				System.out.println("Server: " + greeting);
			}

			while (true) {
				System.out.print("Enter message (type exit to quit): ");
				String message = userIn.readLine();
				if (message == null) {
					break;
				}

				serverOut.println(message);
				String response = serverIn.readLine();
				if (response == null) {
					System.out.println("Server disconnected.");
					break;
				}

				System.out.println("Server: " + response);

				if ("exit".equalsIgnoreCase(message)) {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("Client error: " + e.getMessage());
		}
	}

	private static void printUsage() {
		System.out.println("Usage:");
		System.out.println("java cilent server");
		System.out.println("java cilent client");
	}
}
