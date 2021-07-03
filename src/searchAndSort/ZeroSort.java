package searchAndSort;

/**
 * 一个int数组，把0挪到最后面，其他数的相对位置不变
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/27
 */
public class ZeroSort {
    public static void main(String[] args) {
        ZeroSort zeroSort = new ZeroSort();
        int[] a = new int[]{0, 1, 0, 3, 0, 4, 6, 0};
        zeroSort.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public void sort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 0) {
                continue;
            }
            int j = i;
            while (j > 0 && a[j - 1] == 0) {
                swap(a, j, j - 1);
                j--;
            }
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
