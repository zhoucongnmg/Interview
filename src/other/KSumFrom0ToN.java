package other;

/**
 * 计算0-n中数字k出现的次数
 *
 * 注意，多次没写上
 *
 * @author zc
 */
public class KSumFrom0ToN {

    public static void main(String[] args) {
        KSumFrom0ToN ks = new KSumFrom0ToN();
        System.out.println(ks.getSum(100, 2));
    }

    public int getSum(int n, int k) {
        if (n < 0) {
            return -1;
        }
        String s = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += getSumByBit(n, k, s.length() - i - 1);
        }
        return sum;
    }

    public int getSumByBit(int n, int k, int i) {
        int pow = (int) Math.pow(10, i);
        int cur = n / pow % 10;
        int before = n / pow / 10;
        int after = n % pow;

        if (cur == k) {
            return before * pow + after + 1;
        } else if (cur < k) {
            return before * pow;
        } else {
            return (before + 1) * pow;
        }
    }
}
