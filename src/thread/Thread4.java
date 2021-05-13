package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加。
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/13
 */
public class Thread4 {
    public static void main(String[] args) throws Exception {
        Thread4 thread4 = new Thread4();
        System.out.println(thread4.method());
    }

    private int method() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futures = new ArrayList<>();
        int start = 1;
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                futures.add(executorService.submit(new Task(start, i)));
                start = i;
            }
        }
        int sum = 0;
        for (int i = 0; i < futures.size(); i++) {
            sum += futures.get(i).get();
        }
        //注意，用线程池的话，一定要关闭线程池
        executorService.shutdown();
        return sum;
    }
}

class Task implements Callable<Integer> {

    private int start;
    private int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getId() + ",start:" + start + ",end:" + end + ",sum:" + sum);
        return sum;
    }
}
