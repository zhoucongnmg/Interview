package thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者消费者模型
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/13
 */
public class Broker {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println(Thread.currentThread().getId() + ",produce:" + i);
                        queue.put(i);
                    } catch (InterruptedException e) {
                        //TODO
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        int value = queue.take();
                        System.out.println(Thread.currentThread().getId() + ",consume:" + value);
                    } catch (InterruptedException e) {
                        //TODO
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
