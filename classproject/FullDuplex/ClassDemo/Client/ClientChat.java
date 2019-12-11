package FullDuplex.ClassDemo.Client;

import java.net.Socket;

/**
 * @program: classprogram
 * @Description:
 * @author: WMJ
 * @date: 2019/12/11 20:00 pm
 */
public class Client {
    public static void main(String[] args){
        Socket socket = new Socket("127.0.0.1",8899);
        Thread send = new Thread(new SocketWriter(socket,"Sunshine Boy"));
        Thread reception = new Thread(new SocketReader(socket));
        send.start();
        reception.start();
    }

}
