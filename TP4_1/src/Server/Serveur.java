package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Serveur {
	private static final int port = 1234;
	private static byte[] buffer = new byte[1024];

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(port);
		System.out.println("Demarrage du serveur");
		while (true) {//pour chaque client
			//n3tyh taille du tableau 1024 ou buffer.length
			//userNamePacket : datagram fer8
			
			DatagramPacket userNamePacket = new DatagramPacket(buffer,buffer.length);//a partir du usernamepacket je vais connait l'@ip du client
			socket.receive(userNamePacket);//je vais lire ml port avec un packet vide ce que envoyer le client
			String userName = new String (userNamePacket.getData(),0,userNamePacket.getLength());//ml position 0,usernamepacket.data :t3tyny juste joz2 mtableau mt3 datagrampacket
            //userNamePacket.getLength(): 7asb datagram chnou mwjud fy wstou
			
			System.out.println("Client "+userNamePacket.getAddress()+" userName= "+userName);
			String msgToSend= "Bienvenue :"+userName;//chaine de caractére bch ttb3th ll client
			DatagramPacket packetToSend =new DatagramPacket(msgToSend.getBytes(),msgToSend.length(),userNamePacket.getAddress(),userNamePacket.getPort());
		    //c'est la lettre remplie
			socket.send(packetToSend);
		}
	}

}
