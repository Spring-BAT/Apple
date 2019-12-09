package SimpleExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class DailyAdviceClient {
    public static void main(String[] args){
        DailyAdviceClient client = new DailyAdviceClient();
        client.receiveMsg();
    }

    public void receiveMsg(){
        try {
            Socket socket = new Socket("127.0.0.1", 4242);
            InputStreamReader stream = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(stream);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("Today's advice is:" + line);
            }
            br.close();
        }catch(UnknownHostException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
