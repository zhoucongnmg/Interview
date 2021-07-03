package other;

import java.util.Stack;

/**
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/28
 */
public class NextMax {

    public static void main(String[] args) {
        NextMax mycode = new NextMax();
        int[] a = new int[]{1, 4, 3, 5};
        int[] result = mycode.nextMax(a);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] nextMax(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        Stack<Pair1> stack = new Stack<>();
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && !stack.peek().isFind && a[stack.peek().index] < a[i]) {
                    stack.pop();
                    stack.push(new Pair1(i, true));
                }
            }
            stack.push(new Pair1(i, false));
        }
        int index = a.length - 1;
        while (!stack.isEmpty()) {
            Pair1 pair = stack.pop();
            if (pair.isFind) {
                result[index] = a[pair.index];
            } else {
                result[index] = -1;
            }
            index--;
        }
        return result;
    }

}

class Pair1 {
    int index;
    boolean isFind;

    public Pair1(int index, boolean isFind) {
        this.index = index;
        this.isFind = isFind;
    }
}

