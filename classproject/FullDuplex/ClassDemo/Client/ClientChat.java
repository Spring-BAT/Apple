package FullDuplex.ClassDemo.Client;

import FullDuplex.ClassDemo.ThreadChat.SocketReader;
import FullDuplex.ClassDemo.ThreadChat.SocketWriter;

import java.io.IOException;
import java.net.Socket;

/**
 * @program: classprogram
 * @Description:
 * @author: WMJ
 * @date: 2019/12/11 20:00 pm
 */
public class ClientChat {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8899);
        Thread send = new Thread(new SocketWriter(socket,"Sunshine Boy"));
        Thread reception = new Thread( new SocketReader(socket));
        send.start();
        reception.start();
    }

}
