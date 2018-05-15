package stackAndQueue;

/**
 * 用数组实现stack
 *
 * @author zc
 */
@SuppressWarnings("unchecked")
public class StackWithArray<T> {

    private T[] a;
    private int size;
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

    public StackWithArray(int size) {
        a = (T[]) new Object[size];
        this.size = size;
    }

    public void push(T ele) {
        if (a.length == size) {
            addCapcity();
        }
        index++;
        a[index] = ele;
    }

    public T pop() {
        if (index == -1) {
            return null;
        }
        T ele = a[index];
        a[index] = null;
        index--;
        return ele;
    }

    public int size() {
        return index + 1;
    }

    public boolean isEmpty() {
        return index == -1;
    }

    //扩容
    public void addCapcity() {
        size *= 2;
        T[] temp = (T[]) new Object[size];
        //此处注意 arraycopy均为小写
        System.arraycopy(a, 0, temp, 0, a.length);
        a = temp;
    }
}
