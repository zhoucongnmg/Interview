package searchAndSort;

/**
 * 在旋转数组中查找
 * <p>
 * 注意
 *
 * @author zc
 */
public class SearchInXuanZhuanShuZu {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] c = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int[] d = {1, 2, 1, 1, 1};
        int[] f = {2, 2, 3, 1};
        int[] e = {5, 6, 6, 7, 8, 1, 2, 3, 4};
        int[] g = {5,4,3,6};
        SearchInXuanZhuanShuZu s = new SearchInXuanZhuanShuZu();
        System.out.println(s.findPartMin(g));
        System.out.println(s.findMax(a, 0, a.length - 1));
        System.out.println(s.findMax(b, 0, b.length - 1));
        System.out.println(s.findMax(c, 0, c.length - 1));
        System.out.println(s.findMax(d, 0, d.length - 1));
        System.out.println(s.findMax(f, 0, f.length - 1));
        System.out.println(s.findK(e, 8));
        System.out.println(s.findK(e, 6));
        System.out.println(s.findK(e, 4));
        System.out.println(s.findK(e, 10));
    }

    /**
     * 在旋转数组（先升再降，或者升序）中查找最大值,数组中包含重复数字
     *
     * @param a
     * @return
     */
    public int findMax(int[] a, int start, int end) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (start == end) {
            return a[start];
        }
        int mid = (start + end) / 2;
        if (a[mid] > a[start]) {
            return findMax(a, mid, end);
        } else if (a[mid] < a[start]) {
            return findMax(a, start, mid - 1);
        } else {
            if (mid == start) {
                return a[start] > a[end] ? a[start] : a[end];
            }
            if (a[mid] > a[end]) {
                return findMax(a, mid, end);
            } else if (a[mid] < a[end]) {
                return a[end];
            } else {
                return findmax(a, start, end);
            }
        }
    }

    public int findmax(int[] a, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    /**
     * 旋转数组中查找最小值(返回索引)，数组中有重复元素
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    public int findMin(int[] a, int start, int end) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (a[mid] > a[end]) {
            return findMin(a, mid + 1, end);
        } else if (a[mid] < a[end]) {
            return findMin(a, start, mid);
        } else {
            if (a[mid] > a[start]) {
                return start;
            } else if (a[mid] < a[start]) {
                return findMin(a, start, mid);
            } else {
                return findmin(a, start, end);
            }
        }
    }

    public int findmin(int[] a, int start, int end) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (a[i] < min) {
                min = a[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * 旋转数组中找到值为k的下标。思路：先求出旋转数组最小值，然后在左右两边分别二分查找
     *
     * @param a
     * @param k
     * @return
     */
    public int findK(int[] a, int k) {
        int minIndex = findMin(a, 0, a.length - 1);
        BinarySearch bs = new BinarySearch();
        int i = bs.search(a, 0, minIndex - 1, k);
        if (i == -1) {
            i = bs.search(a, minIndex, a.length - 1, k);
        }
        return i;
    }

    /**
     * 局部最小，一个先降后升的数组中找到最小值下标
     */
    public int findPartMin(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (a.length == 1) {
            return 0;
        }
        return findPartMin(a, 0, a.length - 1);
    }

    public int findPartMin(int[] a, int start, int end) {
        if (start == end) {
            return start;
        }
        if (a[start] < a[start + 1]) {
            return start;
        }
        if (a[end] < a[end - 1]) {
            return end;
        }
        int mid = start + (end - start) / 2;
        if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
            return mid;
        }
        if (a[mid] < a[mid - 1]) {
            return findPartMin(a, mid + 1, end);
        } else {
            return findPartMin(a, start, mid - 1);
        }
    }
}
