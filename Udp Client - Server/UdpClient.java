import java.util.Scanner;
import java.net.*;

/**
 * The class implements a basic udp client to send three strings to an udp server,
 * running on the local machine.
 * Receives two packets from the server one containing a modified version of the concatenation of
 * the strings sents and one containing the total length.
 * Removes the dummy characters inserted from the server (#) and checks if information received 
 * match those sent.
 */

public class UdpClient
{    

    /**
     * Constructor for objects of class Client
     */
    public UdpClient()
    {
    }
        public static void main(String [] arg) throws Exception
        {
            String s1,s2,s3;
            Scanner sc = new Scanner(System.in);
            System.out.println("Please insert S1: ");
            s1 = sc.next();
            System.out.println("Please insert S2: ");
            s2 = sc.next();
            System.out.println("Please insert S3: ");
            s3 = sc.next();
            sc.close();
			//Compute the string c
            String c=s1+s2+s3;
            int l = c.length();
            System.out.println("S1 = " +s1);
            System.out.println("S2 = " +s2);
            System.out.println("S3 = " +s3);
            //manages the network communication 
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IpAddress = InetAddress.getByName("localhost");
            byte [] sendData = new byte[1024];
            byte [] receiveData = new byte[1024];
			//builds and send the packets to the server
            System.out.println("Building Packet 1 containing S1");
            sendData = s1.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IpAddress,4000);
            clientSocket.send(sendPacket);
            System.out.println("Packet 1 sent");
            System.out.println("Building Packet 2 containing S2");
            sendData = s2.getBytes();
            DatagramPacket sendPacket2 = new DatagramPacket(sendData,sendData.length,IpAddress,4000);
            clientSocket.send(sendPacket2);
            System.out.println("Packet 2 sent");
            System.out.println("Building Packet 3 containing S3");
            sendData = s3.getBytes();
            DatagramPacket sendPacket3 = new DatagramPacket(sendData,sendData.length,IpAddress,4000);
            clientSocket.send(sendPacket3);
            System.out.println("Packet 3 sent");
			//receives the packets from the server
            System.out.println("Waiting Server Reply");
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            clientSocket.receive(receivePacket);
            System.out.println("Packet1 from Server received");
            System.out.println("Processing packet");
            String fromServer = new String(receivePacket.getData(),0,receivePacket.getLength());
            System.out.println("Reading Data received");
            System.out.println("String R received from the server  = "+fromServer);
            System.out.println("Processing Data");
			//computes the result string
            String[] dataDetails=fromServer.split("#");
            String s="";
            for(String detail : dataDetails) {
                s+=detail;
            }
            clientSocket.receive(receivePacket);
            clientSocket.close();
            System.out.println("Packet2 from Server received");
            System.out.println("Processing packet");
            fromServer = new String(receivePacket.getData(),0,receivePacket.getLength());
            int n = Integer.parseInt(fromServer);
            System.out.println("Result String R received from the server  = "+s);
            if(s.equals(c)) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
            System.out.println("String length = "+n);
            if(n==l) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    

    
}
