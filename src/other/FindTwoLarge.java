package other;

/**
 * 找出第二大的数字
 * 注意
 *
 * @author zc
 */
public class FindTwoLarge {

    public static void main(String[] args) {
        FindTwoLarge fd = new FindTwoLarge();
        int[] a = {1, 2, 2, 2, 2, 2};
        System.out.println(fd.find(a));
    }

    public Integer find(int[] a) {
        if (a == null || a.length < 2) {
            return null;
        }
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        boolean max2Has = false;
        for (int i : a) {
            if (i > max1) {
                if (max1 > max2) {
                    max2 = max1;
                    max2Has = true;
                }
                max1 = i;
            } else if (max2 < i && i < max1) {
                max2 = i;
                max2Has = true;
            }
        }
        if (max2Has) {
            return max2;
        } else {
            return null;
        }
    }
}
