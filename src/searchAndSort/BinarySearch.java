package searchAndSort;

/**
 * ���ֲ���
 *
 * @author zc
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] a = {0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10};
        int[] d = {2, 3, 4, 5, 6};
        int[] b = {1, 2, 3, 4, 5};
        int[] c = {1, 2, 2, 2, 2};
        int[] e = {4, 5};
        System.out.println(bs.findByRule2(d, 0, 4, 1));
        System.out.println(bs.findByRule2(b, 0, 4, 1));
        System.out.println(bs.findByRule2(c, 0, 4, 2));
        System.out.println(bs.findByRule2(e, 0, 1, 4));
        System.out.println(bs.search(a, 0, a.length - 1, 6));
        System.out.println(bs.search1(a, 0, a.length - 1, 10));

        System.out.println(bs.findByRule(a, 0, a.length - 1, 5));
        System.out.println(bs.findByRule(a, 0, a.length - 1, -1));
        System.out.println(bs.findByRule(e, 0, e.length - 1, 4));

    }

    //�ݹ�ʵ��
    public int search(int[] a, int start, int end, int k) {
        if (a == null) {
            return -1;
        }
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (a[mid] == k) {
            return mid;
        } else if (a[mid] < k) {
            return search(a, mid + 1, end, k);
        } else {
            return search(a, start, mid - 1, k);
        }
    }

    //�ǵݹ�ʵ��
    public int search1(int[] a, int start, int end, int k) {
        if (a == null) {
            return -1;
        }
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (a[mid] == k) {
                return mid;
            } else if (a[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * ��һ���������У�����һ������������ӽ��Ҳ������������λ�ã��������ͬ���ַ������ұߵ��±�
     *
     * @param a
     * @param start
     * @param end
     * @param k
     * @return
     */

    public int findByRule(int[] a, int start, int end, int k) {
        if (a == null) {
            return -1;
        }
        if (start > end) {
            return end;
        }
        int mid = (start + end) / 2;
        if (a[mid] > k) {
            return findByRule(a, start, mid - 1, k);
        } else {
            return findByRule(a, mid + 1, end, k);
        }
    }

    /**
     * ��һ��ֵ���������������һ�γ��ֵ�λ��
     */
    public int findByRule2(int[] a, int start, int end, int k) {
        if (a == null) {
            return -1;
        }
        if (start > end) {
            if (end != -1 && a[end] == k) {
                return end;
            } else {
                return -1;
            }
        }
        int mid = (start + end) / 2;
        if (a[mid] > k) {
            return findByRule2(a, start, mid - 1, k);
        } else {
            return findByRule2(a, mid + 1, end, k);
        }

    }
}