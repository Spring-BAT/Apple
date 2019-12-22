package Progress;

import java.io.*;
import java.net.Socket;

public class SocketThread extends Thread{
    private  Socket socket;
        public SocketThread(Socket socket){
            this.socket = socket;
        }

        public void run(){
           try{
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String temp = null;
                String info = "";
                while ((temp = bufferedReader.readLine()) != null) {
                    info += temp;
                    System.out.println("已接收到客户端连接");
                    System.out.println("服务端接收到客户端信息:" + info + ",当前客户端ip为:" + socket.getInetAddress().getHostAddress());
                }
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.print("你好，服务端已接收到您的信息");
                printWriter.flush();
                socket.shutdownOutput();
                outputStream.close();
                printWriter.close();
                inputStream.close();
           }catch(IOException e){
               e.printStackTrace();
           }
        }

    }

