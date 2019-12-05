package Text;

public class Thread1 extends Thread {
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("Thread-1:running.....");

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
