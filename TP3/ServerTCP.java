package TP3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

    public static void main(String[] args) throws IOException {

        int port = 1234;

        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        serverSocket.close();
        String message = new String();

        while(true){
            InputStream inputStream = socket.getInputStream();

            char y = (char) inputStream.read();
            if(y != '\n'){
                message+= y;
            }
            else if(y == '\n') {
                System.out.println("> " + message);
                message = "";
            }

        }
        //socket.close();

    }
}
