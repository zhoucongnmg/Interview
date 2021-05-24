package other;

import java.util.Stack;

/**
 * 加减乘除运算
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/24
 */
public class Operate {
    public static void main(String[] args) {
        Operate myCode = new Operate();
        String s = "1+2*3";
        System.out.println(myCode.method(s));
        String s1 = "2*3+4/2";
        System.out.println(myCode.method(s1));
        String s2 = "1+2*3*4+4/2/1";
        System.out.println(myCode.method(s2));
        String s3 = "22*10*1+22/11";
        System.out.println(myCode.method(s3));
    }

    public long method(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Long> stackNum = new Stack<>();
        Stack<Character> stackChar = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                Index index = getNextNum(s, i);
                stackNum.push(index.num);
                i = index.rightIndex;
            } else {
                if (c == '+' || c == '-') {
                    stackChar.push(c);
                } else {
                    if (stackNum.isEmpty()) {
                        //TODO 异常
                    }
                    long num1 = stackNum.pop();
                    Index index = getNextNum(s, i + 1);
                    long num2 = index.num;
                    i = index.rightIndex;
                    if (c == '*') {
                        stackNum.push(num1 * num2);
                    } else {
                        stackNum.push(num1 / num2);
                    }
                }
            }
            i++;
        }
        long result = 0;
        while (stackNum.size() > 1 && !stackChar.isEmpty()) {
            char op = stackChar.pop();
            long num2 = stackNum.pop();
            long num1 = stackNum.pop();
            if (op == '+') {
                if (stackNum.isEmpty()) {
                    return num1 + num2;
                }
                stackNum.push(num1 + num2);
            } else {
                if (stackNum.isEmpty()) {
                    return num1 - num2;
                }
                stackNum.push(num1 - num2);
            }
        }
        if (!stackNum.isEmpty() || !stackChar.isEmpty()) {
            //TODO 异常
        }
        return result;
    }

    //获取index位为起始的下一个整数
    public Index getNextNum(String s, int i) {
        StringBuilder builder = new StringBuilder();
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            builder.append(s.charAt(i));
            i++;
        }
        return new Index(Long.valueOf(builder.toString()), i - 1);
    }
}

class Index {

    long num;
    int rightIndex;

    public Index(long num, int rigthIndex) {
        this.num = num;
        this.rightIndex = rigthIndex;
    }
}
