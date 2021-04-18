package stackAndQueue;

import java.util.Stack;

/**
 * ����һ������min������ջ
 * @author zhoucong
 * @version 1.0
 * @date 2021/3/24
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        //ע���ж�minStack�ǲ���Ϊ��
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
