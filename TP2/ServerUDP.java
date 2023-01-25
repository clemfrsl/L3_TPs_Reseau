package TP2;

import java.io.IOException;
import java.net.*;

public class ServerUDP {
    public static void main(String[] args) throws IOException {

        int port = 1234;
        byte msg[] = new byte[512];

        DatagramSocket socket = new DatagramSocket(port);

        while(true) {
            DatagramPacket packet = new DatagramPacket(msg, msg.length);
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println(">"+message);
            System.out.println("From port : "+ packet.getPort());
            socket.send(packet);
        }
    }
}
