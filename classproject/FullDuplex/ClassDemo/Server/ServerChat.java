package FullDuplex.ClassDemo.Server;
import FullDuplex.ClassDemo.ThreadChat.SocketReader;
import FullDuplex.ClassDemo.ThreadChat.SocketWriter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
    public static void main(String[] args) throws IOException {
        int serverPort = 8899;

        ServerSocket server = new ServerSocket(serverPort);

        Socket socket = server.accept();

        Thread send = new Thread(new SocketWriter(socket,"网管"));
        Thread reception = new Thread(new SocketReader(socket));

        send.start();
        reception.start();

    }

}
