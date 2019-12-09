package SimpleExample;

import General.Client;
import General.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class SimpleChatServer {

    private ArrayList clientList = new ArrayList();

    public static void main(String[] args){
        new SimpleChatServer().startUp();
    }

    public void startUp(){
        try{
        ServerSocket serverSocket = new ServerSocket(5000);

        while(true) {
            Socket clientSocket = serverSocket.accept();

            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
            clientList.add(writer);

            Thread t = new Thread(new ClientHandler(clientSocket));
            t.start();

            System.out.println("有Client连进来");
        }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public class ClientHandler implements Runnable{
        private BufferedReader reader;
        private Socket socket;

        public ClientHandler(Socket clientSocket){
            try {
                socket = clientSocket;

                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run(){
            String message;
          try{
            while((message = reader.readLine())!=null) {
                System.out.println("客户端消息:" + message);
                notifyAllClients(message);
            }
            } catch (IOException e) {
              e.printStackTrace();
          }
        }
    }

    public  void notifyAllClients(String message){
        Iterator it = clientList.iterator();
        while(it.hasNext()){
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
