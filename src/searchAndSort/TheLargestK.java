package searchAndSort;

import java.util.PriorityQueue;

/**
 * ���ҵ�k�����
 *
 * @author zc
 */
public class TheLargestK {

    public static void main(String[] args) {
        TheLargestK tk = new TheLargestK();
        int[] a = {1, 2, 3, 3, 3};
        System.out.println(tk.qSearch(a, 0, a.length - 1, 3));
        int[] b = {7, 8};
        System.out.println(tk.qSearch(b, 0, b.length - 1, 2));
//        System.out.println(tk.qSearch2(a, 2));
//        System.out.println(tk.qSearch2(b, 2));

    }

    /**
     * �ÿ�����������㷨�������ٲ���
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

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int getPivot(int[] a, int start, int end) {
        int i = start, j = end;
        int k = a[i];
        while (i < j) {
            while (i<j && a[j] < k) {
                j--;
            }
            while (i<j && a[i] > k) {
                i++;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, i, start);
        return i;
    }

    /**
     * ʹ�����ȼ����У��ѣ�ʵ��
     */
    public int qSearch2(int[] a, int k) {
        if (a == null || a.length < k) {
            return -1;
        }
        // �󶥶�
//        PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // С����
        PriorityQueue<Integer> q = new PriorityQueue<>();
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
