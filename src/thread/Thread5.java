package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/20
 */
public class Thread5 {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static volatile boolean printJ = true;

    public static void main(String[] args) {

        //t1输出基数
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 1; i <= 100; i++) {
                        if (i % 2 != 0) {
                            while (printJ == false) {
                                condition.await();
                            }
                            System.out.print(i);
                            System.out.print(",");
                            printJ = false;
                            condition.signal();
                        }
                    }
                } catch (Exception e) {
                    //TODO
                } finally {
                    lock.unlock();
                }
            }
        });

        //t2输出偶数
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 1; i <= 100; i++) {
                        if (i % 2 == 0) {
                            while (printJ == true) {
                                condition.await();
                            }
                            System.out.print(i);
                            System.out.print(",");
                            printJ = true;
                            condition.signal();
                        }
                    }
                } catch (Exception e) {
                    //TODO
                } finally {
                    lock.unlock();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
