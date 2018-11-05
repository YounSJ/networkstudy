package networkstudy;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketStudy {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket socket = null;
		
		try {
			ss = new ServerSocket(9000);
			System.out.println("Client ready");
			
			socket = ss.accept();
			System.out.println("Client accept");
			System.out.println("Socket: " + ss);
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket != null) socket.close();
				if(ss != null) ss.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
