package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC…
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/13
 */
public class Thread3 {
    private static volatile int print = 1;
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 5; i++) {
                        while (print != 1) {
                            condition.await();
                        }
                        System.out.print("A");
                        print = 2;
                        condition.signalAll();
                    }
                } catch (Exception e) {
                    //TODO
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 5; i++) {
                        while (print != 2) {
                            condition.await();
                        }
                        System.out.print("B");
                        print = 3;
                        condition.signalAll();
                    }
                } catch (Exception e) {
                    //TODO
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 5; i++) {
                        while (print != 3) {
                            condition.await();
                        }
                        System.out.print("C");
                        print = 1;
                        condition.signalAll();
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
        t3.start();
    }
}
