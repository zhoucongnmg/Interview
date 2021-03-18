package stackAndQueue;

/**
 * 用数组实现stack
 *
 * @author zc
 */
@SuppressWarnings("unchecked")
public class StackWithArray<T> {

    private T[] a;
    private int count = 0;
    private int capacity;
    private int index = -1;

    public static void main(String[] args) {
        StackWithArray<Integer> stack = new StackWithArray<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public StackWithArray(int capacity) {
        a = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void push(T ele) {
        if (a.length == count) {
            addCapcity();
        }
        index++;
        count++;
        a[index] = ele;
    }

    public T pop() {
        if (index == -1) {
            return null;
        }
        T ele = a[index];
        a[index] = null;
        index--;
        count--;
        return ele;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    //扩容
    public void addCapcity() {
        capacity *= 2;
        T[] temp = (T[]) new Object[capacity];
        //此处注意 arraycopy均为小写
        System.arraycopy(a, 0, temp, 0, a.length);
        a = temp;
    }
}
