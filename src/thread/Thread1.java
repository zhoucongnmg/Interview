package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程轮流打印数字，一直到100
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/13
 */
public class Thread1 {
    private static int count = 1;
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static volatile boolean print1 = true;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 1; i <= 50; i++) {
                        while (!print1) {
                            //此时才会释放锁
                            //注意一定是await和signal
                            condition.await();
                        }
                        System.out.println(Thread.currentThread().getId() + ":" + count++);
                        print1 = false;
                        //此时不会释放锁
                        condition.signalAll();
                    }
                } catch (Exception e) {
                    //TODO 错误输出
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 1; i <= 50; i++) {
                        while (print1) {
                            condition.await();
                        }
                        System.out.println(Thread.currentThread().getId() + ":" + count++);
                        print1 = true;
                        condition.signalAll();
                    }
                } catch (Exception e) {
                    //TODO 错误输出
                } finally {
                    lock.unlock();
                }
            }
        }).start();

    }
}
