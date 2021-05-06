package other;

/**
 * 约瑟夫环问题
 *
 * 注意
 * @author zc
 */
public class YueSeFuHuan {

    public static void main(String[] args) {
        YueSeFuHuan ysfh = new YueSeFuHuan();
        System.out.println(ysfh.method(5, 2));
    }

    /**
     * @param n 总人数为n
     * @param k 步长为m
     * https://www.jianshu.com/p/6ee5c7b21333
     * @return
     */
    public int method(int n, int k) {
        if (k < 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        //算的时候都当第一个人为0算，返回结果时再将其加1
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + k) % i;
        }
        return dp[n] + 1;
    }
}
