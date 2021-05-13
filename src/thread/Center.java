package thread;

/**
 * 三个窗口同时卖票
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/13
 */
public class Center {
    //只能加锁，因为要保证判断count和扣减count是原子的，用atomicInteger意义不大
    private int count = 10;


    public synchronized boolean sale(int num) {
        if (count >= num) {
            count -= num;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Center center = new Center();
        Thread t1 = new Thread(new Task1(center));
        Thread t2 = new Thread(new Task1(center));
        Thread t3 = new Thread(new Task1(center));
        t1.start();
        t2.start();
        t3.start();
    }
}

class Task1 implements Runnable {

    private Center center;

    public Task1(Center center) {
        this.center = center;
    }

    @Override
    public void run() {
        while (true) {
            boolean success = center.sale(1);
            System.out.println(Thread.currentThread().getId() + ",success:" + success);
            if (!success) {
                break;
            }
        }
    }
}
