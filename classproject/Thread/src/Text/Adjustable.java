package Text;
/**
 * Learn Java Thread
 * Date: 12/5 14:30
 * @author WMJ
 */
public class Adjustable {

    public static void main(String[] args){
        new Thread1().start();
        new Thread2().start();
        for(int i = 0; i < 10; i++){
            System.out.println("main:running...");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
