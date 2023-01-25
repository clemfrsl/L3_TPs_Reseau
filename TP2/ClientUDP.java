package TP2;

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

            DatagramSocket socket = new DatagramSocket();

            while (true) {
                String inputMessage = scanner.nextLine();
                byte[] buffer = inputMessage.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer,0, buffer.length, address, port);
                System.out.println(packet.getAddress());
                socket.send(packet);
            }

        }
    }

}

