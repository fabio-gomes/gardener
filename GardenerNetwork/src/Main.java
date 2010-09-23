
public class Main {
	
	public static void main(String args[]){
		
		System.out.print("testando java novamente");
		
		Server servidor = new Server();
		System.out.print("testando java novamente");
		Client cliente = new Client();

		System.out.print("testando java novamente");
		cliente.connect("192.168.0.150");
		
		System.out.print("testando java novamente");
		servidor.readAMessage();
		cliente.sendAMessage("Testando Sockets.");
		
		cliente.disconnect();
		
	}

}

