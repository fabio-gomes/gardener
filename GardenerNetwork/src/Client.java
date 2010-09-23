import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.nio.channels.FileChannel;

public class Client {

	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	Boolean isConnected;
	
	void connect(String url){
		try {
			socket  = new Socket(InetAddress.getByName(url),12345);
			
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void disconnect(){
		try {
			socket.close();
			
			in.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void checkIn(String source_url, String dest_url) throws IOException{
		String[] strFilesList = getDirectoryList(source_url, "gdn");

		// Cria channel na origem
		FileChannel oriChannel = new FileInputStream(source_url.concat(strFilesList[0].concat(".gdn"))).getChannel();
		// Cria channel no destino
		FileChannel destChannel = new FileOutputStream(dest_url.concat(strFilesList[0].concat(".gdn"))).getChannel();
		// Copia conteúdo da origem no destino
		destChannel.transferFrom(oriChannel, 0, oriChannel.size());

		
		/*for(int i = 0; i < strFilesList.length; i++){
			
			// Copia conteúdo da origem no destino
			destChannel.transferFrom(oriChannel, 0, oriChannel.size());
		}*/
		
	}
	
	void checkOut(String url, File file){
		
	}
	
	void sendAMessage(String str){
		try {
			out.writeUTF(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static String[] getDirectoryList(String url, String type){
		
		File directory = new File(url);
		
		return directory.list(new FileNameFilter("",type));
	}
}
