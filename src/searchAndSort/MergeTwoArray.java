package searchAndSort;

import java.util.*;


/**
 * 合并两个数组，无序，有重复。合并后有序无重复。
 *
 * @author zc
 */
public class MergeTwoArray {

    public static void main(String[] args) {
        int[] a = {2, 2, 4, 5, 2, 1};
        int[] b = {1, 2, 3, 4, 5, 6};
        MergeTwoArray mt = new MergeTwoArray();

        int[] result = mt.mergeTwoArray(a, b);
        if (result != null) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
    }

    public int[] mergeTwoArray(int[] a1, int[] a2) {
        TreeSet<Integer> set = new TreeSet<>();
        if (a1 != null) {
            for (int i : a1) {
                set.add(i);
            }
        }
        if (a2 != null) {
            for (int i : a2) {
                set.add(i);
            }
        }
        if (set.size() == 0) {
            return null;
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int i : set) {
            result[index++] = i;
        }
        return result;
    }
}
