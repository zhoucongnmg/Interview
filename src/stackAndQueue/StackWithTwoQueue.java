package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列实现栈
 *
 * @author zc
 */
public class StackWithTwoQueue<T> {

    Queue<T> pushQ;
    Queue<T> popQ;

    public static void main(String[] args) {
        StackWithTwoQueue<Integer> stack = new StackWithTwoQueue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public StackWithTwoQueue() {
        pushQ = new LinkedList<>();
        popQ = new LinkedList<>();
    }

    public void push(T ele) {
        pushQ.offer(ele);
    }

    public T pop() {
        if (pushQ.isEmpty()) {
            return null;
        }
        while (pushQ.size() > 1) {
            popQ.offer(pushQ.poll());
        }
        Queue<T> temp = pushQ;
        pushQ = popQ;
        popQ = temp;
        return popQ.poll();
    }
}
