package searchAndSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ���������㷨
 *
 * @author zc
 */
public class SortMethod {

    public static void main(String[] args) {
        SortMethod sm = new SortMethod();
        Integer[] a = {5, 4, 3, 2, 1, 1};
//        Integer[] b = {1, 2, 3, 4, 5, 1};
        Integer[] b = {1, 5, 2, 4, 8, 1};
        String[] s = {"d", "c", "b", "a"};
        Integer[] a1 = {1};
//		sm.maopaoSort(a);
//        sm.mergeSort(s, 0, s.length - 1);
//        sm.quickSort(a, 0, a.length - 1);
//        sm.quickSort(b, 0, a.length - 1);
//        sm.quickSort(a);
//        sm.heapSort(a);
        sm.radixSort(a);
        sm.radixSort(b);
        sm.printArray(a);
        sm.printArray(b);
//        sm.printArray(a1);
    }

    /**
     * ð������
     * ��Ҫ�����ܹ�ʹ��compareTo������������������
     *
     * @param a
     */
    public <T extends Comparable<T>> void maopaoSort(T[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    swap(a, j, j - 1);
                }
            }
        }
    }

    /**
     * ��������
     * https://blog.csdn.net/qq_28081081/article/details/80594386
     */
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    /**
     * �鲢����
     */
    public <T extends Comparable<T>> void mergeSort(T[] a, int start, int end) {
        if (a == null) {
            return;
        }
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);

        merge(a, start, end);
    }

    @SuppressWarnings("unchecked")
    public <T extends Comparable<T>> void merge(T[] a, int start, int end) {

        int mid = (start + end) / 2;
        int len = end - start + 1;
        T[] temp = (T[]) new Comparable[len];
        int i = start, j = mid + 1;
        int index = 0;

        while (i <= mid && j <= end) {
            if (a[i].compareTo(a[j]) < 0) {
                temp[index++] = a[i++];
            } else {
                temp[index++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = a[i++];
        }
        while (j <= end) {
            temp[index++] = a[j++];
        }

        System.arraycopy(temp, 0, a, start, end - start + 1);
    }

    /**
     * ��д����
     *
     * @param a
     * @param start
     * @param end
     * @param <T>
     */
    public <T extends Comparable<T>> void quickSort(T[] a, int start, int end) {
        //ע��˴����ж�
        if (a == null || start >= end) {
            return;
        }
        int pivot = getPivot(a, start, end);
        quickSort(a, start, pivot - 1);
        quickSort(a, pivot + 1, end);
    }

    public <T extends Comparable<T>> int getPivot(T[] a, int start, int end) {
        int i = start, j = end, pivot = start;
        while (i < j) {
            while (i < j && a[j].compareTo(a[pivot]) >= 0) {
                j--;
            }
            while (i < j && a[i].compareTo(a[pivot]) <= 0) {
                i++;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, j, pivot);
        return j;
    }

    /**
     * �ǵݹ����
     */
    public <T extends Comparable<T>> void quickSort(T[] a) {
        if (a == null) {
            return;
        }
        int start = 0, end = a.length - 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        stack.push(start);
        while (!stack.isEmpty()) {
            start = stack.pop();
            end = stack.pop();
            if (start >= end) {
                continue;
            }
            int pivot = getPivot(a, start, end);
            stack.push(pivot - 1);
            stack.push(start);
            stack.push(end);
            stack.push(pivot + 1);
        }
    }

    /**
     * �ݹ������
     */
    public <T extends Comparable<T>> void heapSort(T[] a) {
        if (a == null || a.length == 0 || a.length == 1) {
            return;
        }
        int len = a.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            buildHeap(a, i, len - 1);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(a, 0, i);
            buildHeap(a, 0, i - 1);
        }
    }

    //������ �����
    public <T extends Comparable<T>> void buildHeap(T[] a, int foo, int end) {
        int child = foo * 2 + 1;
        if (child > end) {
            return;
        }
        if (child + 1 <= end && a[child + 1].compareTo(a[child]) > 0) {
            child++;
        }
        if (a[child].compareTo(a[foo]) > 0) {
            swap(a, child, foo);
            buildHeap(a, child, end);
        }
    }

    /**
     * ��������
     *
     * @param a
     */
    public void radixSort(Integer[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int len = getMaxLen(a);
        for (int i = 0; i < len; i++) {
            radixSort(a, i);
        }
    }

    private void radixSort(Integer[] a, int i) {
        int pow = (int) Math.pow(10, i);
        List<List<Integer>> buckets = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            buckets.add(new ArrayList<>());
        }
        for (int num : a) {
            int index = num / pow % 10;
            buckets.get(index).add(num);
        }
        int index = 0;
        for (List<Integer> list : buckets) {
            for (int num : list) {
                a[index++] = num;
            }
        }
    }

    private int getMaxLen(Integer[] a) {
        int maxLen = 0;
        for (int i : a) {
            String s = String.valueOf(i);
            if (s.length() > maxLen) {
                maxLen = s.length();
            }
        }
        return maxLen;
    }

    //����
    //�����У��򷽷������У�ʹ�÷��ͱ���1���ڷ�������ֵǰ�������ͣ�����2����������������������
    public <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //��ӡ
    public <T> void printArray(T[] a) {
        for (T i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
