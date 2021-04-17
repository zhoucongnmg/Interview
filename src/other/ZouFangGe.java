package other;

public class ZouFangGe {
    public static void main(String[] args) {
        System.out.println(method(2, 3));
        System.out.println(method2(2, 3));
    }

    //有个4*3的网格，问从左下角走到右上角最短路径的数目,可以扩展为m*n的方格
    public static int method(int m, int n) {
        if (m < 0 || n < 0) {
            return -1;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public static int method2(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        return method2(m - 1, n) + method2(m, n - 1);
    }
}