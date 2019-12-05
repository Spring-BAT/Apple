package Text;

public class Thread2 extends Thread {
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Thread-2:running....");

            try {
                Thread2.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
