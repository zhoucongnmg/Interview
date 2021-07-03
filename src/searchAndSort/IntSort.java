package searchAndSort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一个int数组，重新排序后，使得数组和在一起的数最大，例子：4142 41  -> 414241;  3231,32 ->323231
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/27
 */
public class IntSort {
    public static void main(String[] args) {
        IntSort sort = new IntSort();
        Integer[] a = new Integer[]{4142, 41};
        Arrays.sort(a, new Sorter());
        for (int i : a) {
            System.out.println(i);
        }

        Integer[] a1 = new Integer[]{3231, 32};
        Arrays.sort(a1, new Sorter());
        for (int i : a1) {
            System.out.println(i);
        }

    }

}

class Sorter implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        String s1 = String.valueOf(o1);
        String s2 = String.valueOf(o2);
        int maxLen = Math.max(s1.length(), s2.length());
        int i1, i2;
        for (int i = 0; i < maxLen; i++) {
            i1 = i % s1.length();
            i2 = i % s2.length();
            if (s1.charAt(i1) > s2.charAt(i2)) {
                return -1;
            } else if (s1.charAt(i1) < s2.charAt(i2)) {
                return 1;
            } else {
                continue;
            }
        }
        return 0;
    }
}
