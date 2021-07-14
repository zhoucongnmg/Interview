package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 写两个线程，一个线程打印1~ 52，另一个线程打印A~Z，打印顺序是12A34B…5152Z
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/13
 */
public class Thread2 {
    private static volatile boolean printNum = true;
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static int numIndex= 1;
    private static int charIndex = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        while (numIndex <= 26) {
                            while (!printNum) {
                                condition.await();
                            }
                            System.out.print(numIndex++);
                            System.out.print(numIndex++);
                            printNum = false;
                            condition.signalAll();
                        }
                    } catch (Exception e) {
                        //TODO
                    } finally {
                        lock.unlock();
                    }
                    numIndex = 1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        char[] charArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        while (charIndex < charArray.length) {
                            while (printNum) {
                                condition.await();
                            }
                            System.out.print(charArray[charIndex++]);
                            System.out.print(charArray[charIndex++]);
                            printNum = true;
                            condition.signalAll();
                        }
                    } catch (Exception e) {
                        //TODO
                    } finally {
                        lock.unlock();
                    }
                    charIndex = 0;
                    System.out.println();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
