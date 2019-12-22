package Progress;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("服务端你好，我是客户1");
            printWriter.flush();
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info = "";
            String temp = null;
            while((temp = bufferedReader.readLine())!=null){
                info += temp;
                System.out.println("客户端接收服务端发送的信息:"+info);
            }
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();


        } catch(UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}


