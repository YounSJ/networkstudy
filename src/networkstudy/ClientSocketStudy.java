package networkstudy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketStudy {
	public static void main(String[] args) {
		
		Socket socket = null;
		
		OutputStream outputStream = null;
		DataOutputStream dataOutputStream = null;
		
		InputStream inputStream = null;
		DataInputStream dataInputStream = null;
		
		Scanner scanner = null;
		
		try {
			socket = new Socket("localhost", 9000);
			System.out.println("Server accept");
			
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);
			
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);
			
			scanner = new Scanner(System.in);
			
			while(true) {
				System.out.println("message ");
				String outMessage = scanner.nextLine();
				dataOutputStream.writeUTF(outMessage);
				dataOutputStream.flush();
				
				String inMesssage = dataInputStream.readUTF();
				System.out.println("inMessage: " + inMesssage);
				
				if(outMessage.equals("stop")) break;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(dataOutputStream != null) dataOutputStream.close();
				if(outputStream != null) outputStream.close();
				if(dataInputStream != null) dataInputStream.close();
				if(inputStream != null) inputStream.close();
				if(socket != null) socket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
