package stackAndQueue;

import java.util.Stack;

/**
 * 两个栈实现队列
 * @author zc
 *
 */
public class QueueWithTwoStack<T> {
	Stack<T> s1 = new Stack<T>();
	Stack<T> s2 = new Stack<T>();
	
	public static void main(String[] args){
		QueueWithTwoStack<Integer> q = new QueueWithTwoStack<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.poll();
		q.offer(5);
		while(!q.isEmpty())
			System.out.println(q.poll());
	}
	
	public void offer(T ele){
		s1.push(ele);
	}
	public T poll(){
		if(s2.isEmpty()){
			if(s1.isEmpty())
				return null;
			while(!s1.isEmpty())
				s2.push(s1.pop());
			return s2.pop();
		}
		return s2.pop();
	}
	public boolean isEmpty(){
		return s1.isEmpty() && s2.isEmpty();
	}

	public int size(){
		return s1.size() + s2.size();
	}

	
}
