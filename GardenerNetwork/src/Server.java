import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	
	ServerSocket serverSocket;
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	
	Server(){
		try {
			serverSocket = new ServerSocket(12345,100);

			socket = serverSocket.accept();
			System.out.print("testando java novamente");

			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void readAMessage(){
		String strIn = "";
		try {
			strIn = in.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(strIn);
	}

}
