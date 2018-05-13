package other;

/**
 * ���Լ��
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
     * շת�������ʱ�临�Ӷ�ΪOlogn
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
            //ע��˴� rΪ a%b ������a/b
            r = a % b;
            a = b;
            b = r;
        }
        return b;
    }
}
