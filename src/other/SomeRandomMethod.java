package other;

/**
 * 随机数相关问题
 *
 * @author zc
 */
public class SomeRandomMethod {

    public static void main(String[] args) {

        double x = 3.0;
        int y = 5;
        x /= --y;
        System.out.println(x);
    }

    /**
     * 蓄水池抽样问题
     * 现在有100个数，我要选10个数出来，每个数选出来的概率要是均等。
     * 在数组a中随机抽取n个数，要求每个数被抽到的概率相同
     */
    public int[] xuShuiChiChouYang(int[] a, int n) {
        if (a == null) {
            return null;
        }
        if (a.length < n) {
            return null;
        }
        int[] result = new int[n];
        for (int i = 0; i < a.length; i++) {
            if (i < n) {
                result[i] = a[i];
            } else {
                //1、注意此处随机数写法 2、还要注意转型为int 3、注意一定要先将后面的扩起来，否则结果一直为0
                int ran = (int) (Math.random() * (i + 1));
                if (ran < n) {
                    result[ran] = a[i];
                }
            }
        }
        return result;
    }
}
