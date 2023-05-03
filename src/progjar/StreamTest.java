package progjar;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StreamTest {
	public static void main(String[] args) {
		try {			
			ServerSocket server = new ServerSocket(6666);
			Socket client = server.accept();
			
//			BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
//			BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());

			DataInputStream bis = new DataInputStream(client.getInputStream());
			DataOutputStream bos = new DataOutputStream(client.getOutputStream());
			
//			String buf = new String(bis.readAllBytes());
			String buf = new String(bis.readLine());
			bos.write(buf.getBytes());
			
			client.close();
			server.close();
		} catch (Exception e) {
			// TODO: handle exception
//			Logger.getLogger(StreamTest.class);
			System.out.println(e);
		}
	}

}
