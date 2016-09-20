import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2016/9/14.
 */
public class ExecutorDemo {
    public static void main(){
        ExecutorService exe= Executors.newFixedThreadPool(2);
        exe.execute(new PrintA());
        exe.execute(new Print9());
        exe.shutdown();
    }

}
class PrintA implements Runnable{
    public void run() {
        System.out.print(" A");
    }
}

class Print9 implements Runnable {
    public void run(){
        System.out.print(" 9");
    }
}
