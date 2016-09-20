import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/9/14.
 */
public class ThreadCooperation {
    private static Account account=new Account();
    public static void main(){
        ExecutorService exe= Executors.newFixedThreadPool(2);
        exe.execute(new task1());
        exe.execute(new task2());
        exe.shutdown();
        System.out.println("Thread 1\t\tThred 2\t\tbalance");
    }

    public static class task1 implements Runnable{
        public void run(){
            try {
                while (true) {
                    account.deposit((int) Math.random() * 10 + 1);
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
    public static class task2 implements Runnable{
        public void run(){
            while (true) {
                    account.withdraw((int) Math.random() * 10 + 1);
                }
            }
        }

    private static  class Account{
        private static Lock lock=new ReentrantLock();
        private static Condition cond=lock.newCondition();
        private int balance=0;
        public int getBalance(){
            return balance;
        }
        public void withdraw(int amount){
            lock.lock();
            try{
                while(balance<amount){
                    System.out.println("\t\t\twait for a cond");
                    cond.await();
                }
                balance-=amount;
                System.out.println("\t\t\twithdraw " + amount + "\t\t" + getBalance());
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void deposit(int amount){
            lock.lock();
            try{
                balance+=amount;
                System.out.println("Deposit " + amount + "\t\t\t\t\t" + getBalance());
                cond.signalAll();
            }
            finally {
                lock.unlock();
            }
        }

    }
}
