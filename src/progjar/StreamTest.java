package progjar;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StreamTest {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(6666);
			Socket socket = server.accept();

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Person p = (Person) ois.readObject();
			System.out.println("Name: " + p.getFullName());
			System.out.println("Age: " + p.getAge());

			ois.close();
			socket.close();
			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
