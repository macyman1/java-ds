import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class networking {
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
			System.out.println("Server is waiting for a client connection...");

			try (Socket socket = serverSocket.accept();
				 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

				System.out.println("Client connected: " + socket.getInetAddress());

				while (true) {
					String message = in.readLine();
					if (message == null) {
						System.out.println("Client disconnected.");
						break;
					}

					System.out.println("Received from client: " + message);

					if ("exit".equalsIgnoreCase(message)) {
						out.println("Goodbye from server.");
						System.out.println("Sent to client: Goodbye from server.");
						break;
					}

					String response = "Server reply: " + message.toUpperCase();
					out.println(response);
					System.out.println("Sent to client: " + response);
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
			while (true) {
				System.out.print("Enter a message to send to server (type exit to quit): ");
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

				System.out.println("Response from server: " + response);

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
		System.out.println("1) Start server: java networking server");
		System.out.println("2) Start client: java networking client");
	}
}
