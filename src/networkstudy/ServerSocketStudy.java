package networkstudy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketStudy {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket socket = null;
		
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		
		InputStream inputStream = null;
		DataInputStream dataInputStream = null;
		
		try {
			ss = new ServerSocket(9000);
			System.out.println("Client ready");
			
			socket = ss.accept();
			System.out.println("Client accept");
			System.out.println("Socket: " + ss);
			
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			while(true) {
				String clientMessage = dataInputStream.readUTF();
				System.out.println("clientMessage: " + clientMessage);
				
				dataOutputStream.writeUTF("Message complete");
				dataOutputStream.flush();
				
				if(clientMessage.equals("stop")) break;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(dataInputStream != null) dataInputStream.close();
				if(inputStream != null) inputStream.close();
				if(dataOutputStream != null) dataOutputStream.close();
				if(outputStream != null) outputStream.close();
				
				if(socket != null) socket.close();
				if(ss != null) ss.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
