package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �����߳�������ӡ���֣�һֱ��100
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
                            //��ʱ�Ż��ͷ���
                            //ע��һ����await��signal
                            condition.await();
                        }
                        System.out.println(Thread.currentThread().getId() + ":" + count++);
                        print1 = false;
                        //��ʱ�����ͷ���
                        condition.signalAll();
                    }
                } catch (Exception e) {
                    //TODO �������
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
                    //TODO �������
                } finally {
                    lock.unlock();
                }
            }
        }).start();

    }
}
