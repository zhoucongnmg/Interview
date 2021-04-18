package other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhoucong
 * @time 2018/6/5
 */
public class BlockingQueue<T> {
    private ReentrantLock lock;
    private Condition notFull;
    private Condition notEmpty;
    private Object[] arrays;
    private int index = -1;
    private int count = 0;

    public BlockingQueue(int capacity) {
        //ֻҪ����ʵ�������飬�κ�ʱ�����arrays.length ����capacity
        arrays = new Object[capacity];
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    //ע��interrupt�쳣��await������lock�ڣ�await��singal���
    public void put(T value) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count == arrays.length) {
                notFull.await();
            }
            arrays[++index] = value;
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object result = arrays[index];
            arrays[index--] = null;
            count--;
            notFull.signal();
            return (T) result;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new BlockingQueue<>(1);
        queue.put(1);
    }
}
