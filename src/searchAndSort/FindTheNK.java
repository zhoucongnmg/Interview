package searchAndSort;

/**
 * 找到第N个 值为K的数,返回下标,下面为数组有序的解法，如果数组无序可以使用map
 *
 * @author zc
 */
public class FindTheNK {


    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 4, 5, 6};
        FindTheNK ftn = new FindTheNK();
        System.out.println(ftn.find(a, 2, 2));
        System.out.println(ftn.find(a, 10, 2));
        System.out.println(ftn.find(a, 2, 10));
    }

    public int find(int[] a, int n, int k) {
        if (a == null) {
            return -1;
        }
        if (n <= 0) {
            return -1;
        }
        int left = findLeft(a, 0, a.length - 1, k);
        if (left == -1) {
            return -1;
        }
        //此处注意校验
        if (left + n - 1 < a.length && a[left + n - 1] == k) {
            return left + n - 1;
        }
        return -1;
    }

    //找到k的最左边位置

    /**
     * 找一个值在有序数组中第一次出现的位置
     *
     * @param a
     * @param start
     * @param end
     * @param k
     * @return
     */
    public int findLeft(int[] a, int start, int end, int k) {
        if (a == null) {
            return -1;
        }
        if (start > end) {
            //注意此处校验
            if (start <= a.length && a[start] == k) {
                return start;
            } else {
                return -1;
            }
        }
        int mid = (start + end) / 2;
        if (a[mid] < k) {
            return findLeft(a, mid + 1, end, k);
        } else {
            return findLeft(a, start, mid - 1, k);
        }

    }

    /**
     * 找一个值在有序数组中最后一次出现的位置
     */
    public int findRight(int[] a, int start, int end, int k) {
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
            return findRight(a, start, mid - 1, k);
        } else {
            return findRight(a, mid + 1, end, k);
        }

    }
}
