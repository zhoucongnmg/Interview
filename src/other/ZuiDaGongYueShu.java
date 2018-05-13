package other;

/**
 * 最大公约数
 *
 * @author zc
 */
public class ZuiDaGongYueShu {

    public static void main(String[] args) {
        ZuiDaGongYueShu zdgys = new ZuiDaGongYueShu();
        System.out.println(zdgys.compute(27, 15));
//		System.out.println(zdgys.compute2(27,15));
    }

    /**
     * 辗转相除法，时间复杂度为Ologn
     *
     * @param a
     * @param b
     * @return
     */
    public int compute(int a, int b) {
        int temp = 0;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (b == 0) {
            return 0;
        }
        int r = 0;
        while (a % b != 0) {
            //注意此处 r为 a%b 而不是a/b
            r = a % b;
            a = b;
            b = r;
        }
        return b;
    }
}
