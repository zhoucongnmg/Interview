package sync;

import java.util.concurrent.*;

/**
 * @author zhoucong
 * @time 2018/5/15
 */
public class FutureTest {
    private static ThreadPoolExecutor threadPoolExecutor = new AsyncThread(2);
    static BlockingQueue<Future<Integer>> resultQueue = new LinkedBlockingQueue<>(4);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                Future<Integer> future = null;
                try {
                    future = resultQueue.poll(100, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer result = null;
                try {
                    if (future == null) {
                        continue;
                    }
                    result = future.get();
                    System.out.println(result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                if (result == null) {
                    System.out.println("½áÊø");
                }
            }
        });
        thread.start();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            int finalI1 = i;
            resultQueue.put(threadPoolExecutor.submit(() -> {
                Thread.sleep((10- finalI1)*1000);
                return finalI;
            }));
        }
        resultQueue.put(new StopFuture<>(null));
        while (true) {

        }

    }

}
