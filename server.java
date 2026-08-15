import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	private static final int PORT = 5000;

	public static void main(String[] args) {
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
}