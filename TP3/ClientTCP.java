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

        InputStream inputStream = socket.getInputStream();
        int message = inputStream.read();
        System.out.println("message = " + message);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message+1);
        message = inputStream.read();
        System.out.println("message = " + message);

        socket.close();

    }
}
