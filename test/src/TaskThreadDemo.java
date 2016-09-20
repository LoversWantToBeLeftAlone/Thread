/**
 * Created by Administrator on 2016/9/14.
 */
public class TaskThreadDemo {
    public static void main(String[]args) {
        Runnable print100 = new PrintNum(100);
        Runnable print333 = new PrintNum(333);
        Thread t1 = new Thread(print100);
        Thread t2 = new Thread(print333);
        t1.start();
        t2.start();
    }
}
class PrintNum implements Runnable{
    private int num;
    public PrintNum(int n){
        num=n;
    }
    public void run(){
        for(int i=0;i<num;i++){
            System.out.print(" "+i);
        }
    }
}
