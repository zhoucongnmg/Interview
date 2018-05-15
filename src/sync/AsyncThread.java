package sync;

import java.util.concurrent.*;

/**
 * @author zhoucong
 * @time 2018/5/15
 */
public class AsyncThread extends ThreadPoolExecutor {
    public AsyncThread(int poolSize) {
        super(poolSize, poolSize, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(poolSize),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        try {
                            executor.getQueue().put(r);
                        } catch (InterruptedException e) {
                        }
                    }
                });
    }

    public AsyncThread(int poolSize, ThreadFactory threadFactory) {
        super(poolSize, poolSize, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(poolSize), threadFactory,
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        try {
                            executor.getQueue().put(r);
                        } catch (InterruptedException e) {
                        }
                    }
                });
    }
}
