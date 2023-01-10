import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();
        int port;
        InetAddress address;

        if(args[1] != null && args[2] != null){
            port = Integer.parseInt(args[1]);
            address = InetAddress.getByName(args[2]);
        }
        else{
            port = 1234;
            address = InetAddress.getByName("localhost");
        }

        byte[] buffer = new byte[512];
        DatagramSocket socket = new DatagramSocket(port, address);

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.send(packet);


    }

}
