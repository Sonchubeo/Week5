package School;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ViduSever {
	public static void main(String[] args) {
		final int PORT=12345;
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("sever dang ket noi tu client");
			while (true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("client da ket noi "+clientSocket);
				Thread thread = new Thread(new ClientHander(clientSocket));
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	class ClientHander implements Runnable{
		private Socket clienSocket;
		public ClientHander(Socket clientSocket) {
			this.clienSocket = clientSocket;
		}
		@Override
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clienSocket.getOutputStream(),true);
				String clinetMes;
				while((clinetMes= in.readLine())!=null) {
					System.out.println("Client gui "+clinetMes);
					out.println("Server nhan duoc "+clinetMes);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
