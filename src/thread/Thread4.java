package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ��д10���̣߳���һ���̴߳�1�ӵ�10���ڶ����̴߳�11��20����ʮ���̴߳�91�ӵ�100������ٰ�10���߳̽����ӡ�
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
        //ע�⣬���̳߳صĻ���һ��Ҫ�ر��̳߳�
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
