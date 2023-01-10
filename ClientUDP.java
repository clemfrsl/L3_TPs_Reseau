import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) throws IOException {
        int port;
        InetAddress address;

        if(args[1] != null && args[2] != null){
            port = Integer.parseInt(args[2]);
            address = InetAddress.getByName(args[1]);
        }
        else{
            port = 1234;
            address = InetAddress.getByName("localhost");
        }

        Scanner scanner = new Scanner(System.in);
        String inputMessage = scanner.next();

        byte[] buffer = inputMessage.getBytes();
        DatagramSocket socket = new DatagramSocket(port, address);

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.send(packet);
        socket.receive(packet);



    }

}

