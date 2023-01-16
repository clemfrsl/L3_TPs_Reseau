import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) throws IOException {
        if(args[0] == null || args[1] == null){
            System.out.println("Error, server or port not found.");
        }
        else {

            int port = Integer.parseInt(args[1]);
            InetAddress address = InetAddress.getByName(args[0]);

            Scanner scanner = new Scanner(System.in);
            String inputMessage = scanner.next();

            byte[] buffer = inputMessage.getBytes();
            DatagramSocket socket = new DatagramSocket(port, address);

            DatagramPacket packet = new DatagramPacket(buffer,0, buffer.length, address, port);
            socket.send(packet);
            socket.receive(packet);

            while (true) {
                socket.receive(packet);
                System.out.println(packet.getAddress());
                socket.send(packet);
            }

        }
    }

}

