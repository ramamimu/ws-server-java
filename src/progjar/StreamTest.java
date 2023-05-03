package progjar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class StreamTest {
	public static void main(String[] args) {
		try {			
			Socket socket = new Socket("my.its.ac.id", 443);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			String msg = "GET / HTTP/1.1\r\nHost: my.its.ac.id\r\n\r\n";
			bw.write(msg);
			bw.flush();

			String resp = br.readLine();
			while (resp != null) {
			// while (!resp.equalsIgnoreCase("")) {
				System.out.println(resp);
				resp = br.readLine();
			}
			br.close();
			bw.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
