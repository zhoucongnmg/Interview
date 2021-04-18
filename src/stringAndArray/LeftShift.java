package stringAndArray;

import java.util.Arrays;

/**
 * 循环移位
 *
 * @author zc
 */
public class LeftShift {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        LeftShift lf = new LeftShift();
        lf.leftShift(a, 3);
        System.out.println(Arrays.toString(a));
        System.out.println(lf.leftShift2("12345", 3));
        System.out.println(lf.isContains("abcd", "cda"));
    }

    /**
     * 数组左移
     */
    public void leftShift(int[] a, int k) {
        if (a == null || a.length < 2) {
            return;
        }
        k = k % a.length;
        int[] temp = new int[k];
        System.arraycopy(a, 0, temp, 0, k);
        System.arraycopy(a, k, a, 0, a.length - k);
        System.arraycopy(temp, 0, a, a.length - k, k);

    }

    /**
     * 左移字符串
     * 剑指 Offer 58
     */
    public String leftShift2(String s, int k) {
        if (s == null || s.length() < 2) {
            return s;
        }
        //注意k可能超过s长度
        k = k % s.length();
        String right = s.substring(0, k);
        String left = s.substring(k);
        return left + right;
    }

    /**
     * 判断其中一个字符串是不是另一个字符串的右移子串。如cda是abcd的右移子串。
     */
    public boolean isContains(String s, String sub) {
        if (s == null || sub == null) {
            return false;
        }
        s += s;
        return s.contains(sub);
    }
}
