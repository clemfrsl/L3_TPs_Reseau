package TP3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

    public static void main(String[] args) throws IOException {

        //cas UDP
        int port = 1234;

        ServerSocket serverSocket = new ServerSocket(port);

        while(true){
            Socket socket = serverSocket.accept();
            serverSocket.close();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(2);
            InputStream inputStream = socket.getInputStream();
            int y = inputStream.read();
            System.out.println("> y = "+ y);
            socket.close();
        }

    }
}
