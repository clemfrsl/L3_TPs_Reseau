import java.io.IOException;
import java.net.*;

public class ServerUDP {
    public static void main(String[] args) throws IOException {

        int port = 1234;
        byte msg[] = new byte[512];

        DatagramSocket socket = new DatagramSocket(port);
        DatagramPacket packet = new DatagramPacket(msg, msg.length);
        socket.receive(packet);

        String message = new String(packet.getData());
        System.out.println(message);
        DatagramPacket response = new DatagramPacket(msg, msg.length);
        socket.send(response);

    }
}
