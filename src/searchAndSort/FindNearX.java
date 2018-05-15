package searchAndSort;

/**
 * 给你一个数x，在无序数组里找一个与这个数x最接近的数并返回
 *
 * @author zc
 */
public class FindNearX {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        FindNearX fn = new FindNearX();
        try {
            System.out.println(fn.findNear(a, 0));
            System.out.println(fn.findNear(a, 6));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Integer findNear(int[] a, int value) {
        if (a == null || a.length == 0) {
            return null;
        }
        int minSub = Integer.MAX_VALUE;
        int min = a[0];
        for (int i : a) {
            int cur = Math.abs(i - value);
            if (cur < minSub) {
                minSub = cur;
                min = i;
            }
        }
        return min;
    }
}
