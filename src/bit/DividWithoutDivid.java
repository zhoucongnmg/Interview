package bit;

/**
 * ���ó˳���ʵ�ֳ���
 *
 * ����ʱע����ţ�ע�������߽磨������ӡ���ˡ�ȡ����ֵ��
 *
 * leet 29
 * @author zc
 */
public class DividWithoutDivid {

    public static void main(String[] args) {
        DividWithoutDivid t = new DividWithoutDivid();
        try {
            System.out.println(t.divide(-2147483648, -1));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public long divide(int dividend, int divisor) throws Exception {
        if (divisor == 0) {
            throw new Exception();
        }
        int sign = 0;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            sign = 1;
        } else {
            sign = -1;
        }

        //�˴�Ҫע�� Math��abs����һ��Ҫ��long
        long div1 = Math.abs((long) dividend);
        long div2 = Math.abs((long) divisor);
        long result = 0, temp = div2, cur = 1;
        while (div1 >= div2) {
            while (div1 >= temp) {
                temp <<= 1;
                cur <<= 1;
            }
            temp >>= 1;
            cur >>= 1;
            result += cur;
            div1 -= temp;
            cur = 1;
            temp = div2;
        }
        if (sign == -1) {
            //����ȡ�������ű���ţ����ű�����,��Ŀ�涨�����ó˳���
            result = ~result + 1;
        }
        return result;
    }

}
