package TP4;

import org.w3c.dom.css.Counter;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Stress1 {
    private int counter;

    public Stress1(int counter) throws IOException {
        this.counter = counter;
        this.runClients();
    }

    public void runClients() throws IOException {
        for(int n = 1; n <= counter; n++){
            Socket socket = new Socket();
            InetSocketAddress address = new InetSocketAddress(1234);
            socket.connect(address);
            byte[] buffer = ("le client "+ n + " se connecte \n").getBytes();
            System.out.println(n);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(buffer);
            socket.close();
        }
    }
}
