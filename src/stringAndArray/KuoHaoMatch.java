package stringAndArray;

import java.util.Stack;

/**
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/2
 */
public class KuoHaoMatch {

    /**
     * ����һ��ֻ���� '(' �� ')' ���ַ������ҳ����Ч����ʽ��ȷ�������������Ӵ��ĳ��ȡ�
     * leet:32
     * <p>
     * ƥ���ϵ���1��ʾ��ת��Ϊ�������1
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int max = 0;
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int[] match = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charStack.isEmpty()) {
                charStack.push(c);
                indexStack.push(i);
            } else {
                if (c == ')' && charStack.peek() == '(') {
                    charStack.pop();
                    match[i] = 1;
                    match[indexStack.pop()] = 1;
                } else {
                    charStack.push(c);
                    indexStack.push(i);
                }
            }
        }
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (match[i] == 1) {
                cur++;
            } else {
                cur = 0;
            }
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}
