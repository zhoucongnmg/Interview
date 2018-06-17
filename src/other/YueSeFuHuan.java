package other;

/**
 * Լɪ������
 *
 * ע��
 * @author zc
 */
public class YueSeFuHuan {

    public static void main(String[] args) {
        YueSeFuHuan ysfh = new YueSeFuHuan();
        System.out.println(ysfh.method(5, 2));
    }

    /**
     * @param n ������Ϊn
     * @param m ����Ϊm
     * @return
     */
    public int method(int n, int m) {
        if (m < 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        //���ʱ�򶼵���һ����Ϊ0�㣬���ؽ��ʱ�ٽ����1
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + m) % i;
        }
        return dp[n] + 1;
    }
}
