package TP4;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientHandler extends Thread{
    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        String message = "";
        while(true){
            InputStream inputStream;
            try {
                inputStream = socket.getInputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            char c;
            try {
                c = (char) inputStream.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(c != '\n'){
                message+= c;
                System.out.println("> " + message);
            }
            else {
                System.out.println("> " + message);
                message = "";
            }

        }
    }


}
