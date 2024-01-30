package School;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ViduClient {
	public static void main(String[] args) {
        final String ServerAdress = "localhost";
        final int PORT = 12345;
        try {
            Socket socket = new Socket(ServerAdress, PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client da ket noi server");
            String userInputLine = "";
            while ((userInputLine = userInput.readLine()) != null) {
                out.println(userInputLine);
                String response = in.readLine();
                System.out.println("Server tra ve: "+ response);
            }
        } catch (Exception e) {
        }
    }
}
