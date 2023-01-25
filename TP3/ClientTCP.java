package TP3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;

public class ClientTCP {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Socket socket = new Socket();
        InetSocketAddress address = new InetSocketAddress(1234);
        socket.connect(address);

        while(scanner.hasNextLine()) {
            String inputMessage = scanner.nextLine() + '\n';
            byte[] buffer = inputMessage.getBytes();

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(buffer);
        }

        socket.close();

    }
}
