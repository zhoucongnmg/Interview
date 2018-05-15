package searchAndSort;

import java.util.PriorityQueue;

/**
 * 查找第k大的数
 *
 * @author zc
 */
public class TheLargestK {

    public static void main(String[] args) {
        TheLargestK tk = new TheLargestK();
        int[] a = {1, 2, 3, 3, 3};
        System.out.println(tk.qSearch(a, 0, a.length - 1, 3));
        int[] b = {8, 7, 6, 5, 4, 3, 2, 1, 1};
        System.out.println(tk.qSearch(b, 0, b.length - 1, 9));
        System.out.println(tk.qSearch2(a, 3));
        System.out.println(tk.qSearch2(b, 3));

    }

    /**
     * 用快速排序变形算法，即快速查找
     *
     * @return
     */
    public int qSearch(int[] a, int start, int end, int k) {
        if (a == null || a.length < k) {
            return -1;
        }
        if (start >= end) {
            return a[k - 1];
        }
        int pivot = getPivot(a, start, end);
        if (pivot == k - 1) {
            return a[k - 1];
        } else if (pivot > k - 1) {
            return qSearch(a, start, pivot - 1, k);
        } else {
            return qSearch(a, pivot + 1, end, k);
        }
    }

    public void setMid(int[] a, int start, int end) {
        int mid = start + (end - start) / 2;
        if (a[start] < a[mid]) {
            swap(a, start, mid);
        }
        if (a[start] < a[end]) {
            swap(a, start, end);
        }
        if (a[mid] < a[end]) {
            swap(a, mid, end);
        }
        swap(a, mid, end - 1);
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int getPivot(int[] a, int start, int end) {
        setMid(a, start, end);
        int i = start, j = end - 2;
        int k = a[end - 1];
        while (i <= j) {
            while (a[i] > k) {
                i++;
            }
            while (a[j] < k) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        swap(a, i, end - 1);
        return i;
    }

    /**
     * 使用优先级队列（堆）实现
     */
    public int qSearch2(int[] a, int k) {
        if (a == null || a.length < k) {
            return -1;
        }
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i : a) {
            if (q.size() == k) {
                if (i > q.peek()) {
                    q.poll();
                    q.offer(i);
                }
            } else {
                q.offer(i);
            }
        }
        return q.peek();
    }
}
