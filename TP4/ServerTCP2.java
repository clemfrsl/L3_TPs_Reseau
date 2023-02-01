package TP4;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP2 {

    public static void main(String[] args) throws IOException {

        int port = 1234;

        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();

        String message = "";

        ClientHandler clientHandler = new ClientHandler(socket);

        while(true){
            InputStream inputStream = socket.getInputStream();

            char c = (char) inputStream.read();
            if(c != '\n'){
                message+= c;
            }
            else if(c == '\n') {
                System.out.println("> " + message);
                message = "";
            }

        }
        //socket.close();

    }
}
