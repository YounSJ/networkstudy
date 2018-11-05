package networkstudy;

import java.net.Socket;

public class ClientSocketStudy {
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			socket = new Socket("localhost", 9000);
			System.out.println("Server accept");
			System.out.println("Socket: " + socket);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket != null) socket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
