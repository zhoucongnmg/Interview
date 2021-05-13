package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/13
 */
public class AddAndSub {
    public static void main(String[] args){
        AddAndSub addAndSub = new AddAndSub();
        AtomicInteger num = new AtomicInteger(0);
        Thread t1 = new Thread(new AddTask(num));
        Thread t2 = new Thread(new AddTask(num));
        Thread t3 = new Thread(new SubTask(num));
        Thread t4 = new Thread(new SubTask(num));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class AddTask implements Runnable {

    private AtomicInteger num;

    public AddTask(AtomicInteger num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int result = num.incrementAndGet();
            System.out.println(Thread.currentThread().getId() + ",addresult:" + result);
        }
    }
}

class SubTask implements Runnable {

    private AtomicInteger num;

    public SubTask(AtomicInteger num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int result = num.decrementAndGet();
            System.out.println(Thread.currentThread().getId() + ",subresult:" + result);
        }
    }
}
