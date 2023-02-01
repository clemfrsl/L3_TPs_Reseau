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
            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            char c = 0;
            try {
                c = (char) inputStream.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(c != '\n'){
                message+= c;
            }
            else if(c == '\n') {
                System.out.println("> " + message);
                message = "";
            }

        }
    }


}
