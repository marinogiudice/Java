import java.net.*;

/**
 * The Class implements a basic Udp Server, to receive 3 strings in 3 packets from an udp client.
 * Computes a new string, joining the strings received from the client and adding an hashtag character (#)
 * between them.
 * Sends back to the client two packets one containing the computed string and one containing the total length
 * of the strings received.
 */

public class UdpServer
{
    public static void main(String[] arg) throws Exception
    {
        //manages the network communication
        DatagramSocket serverSocket = new DatagramSocket(4000);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        //continuosly wait from packets from the client
        while(true)
        {
            System.out.println("Waiting for packets from the client");
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            serverSocket.receive(receivePacket);
            System.out.println("Packet 1 Received");
            System.out.println("Processing packet");
            //retrieves string s1 from the packet received from the client
            int length = receivePacket.getLength();
            String s1 = new String(receivePacket.getData(),0,length);
            System.out.println("Waiting for packets from the client");
            serverSocket.receive(receivePacket);
            System.out.println("Packet 2 received");
            System.out.println("Processing packet");
            //retrieves string s2 from the packet received from the client
            length = receivePacket.getLength();
            String s2 = new String(receivePacket.getData(),0,length);
            System.out.println("Waiting for packets from the client");
            serverSocket.receive(receivePacket);
            System.out.println("Packet 3 received");
            System.out.println("Processing packet");
            //retrieves string s3 from the packet received from the client
            length = receivePacket.getLength();
            String s3 = new String(receivePacket.getData(),0,length);
            System.out.println("Computing Input strings total length n");
            int n = (s1.length() + s2.length() + s3.length());
            System.out.println("Computing Result String");
            //builds the string to send to the client
            String result = (s1 +"#"+ s2 +"#"+s3);
            System.out.println("Building output packet1");
            sendData = result.getBytes();
            InetAddress clientAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,clientAddress,port);
            serverSocket.send(sendPacket);
            System.out.println("Packet1 sent to the client");
            System.out.println("Building output packet2");
            sendData = Integer.toString(n).getBytes();
            sendPacket = new DatagramPacket(sendData,sendData.length,clientAddress,port);
            serverSocket.send(sendPacket);
            System.out.println("Packet2 sent to the client");
            
        }
    }
}
