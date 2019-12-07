package Progress;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try{
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端已启动，等待客户端连接....");
        while(true){
            Socket socket = serverSocket.accept();
            SocketThread socketThread = new SocketThread(socket);
            socketThread.start();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
