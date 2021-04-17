package other;

public class LeetCode121 {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * leet:121
     * @param a
     * @return
     */
    public int method(int[] a) {
        if (a == null || a.length < 2) {
            return 0;
        }
        int max = 0;
        int start = 0;
        for (int i = 0; i < a.length; i++) {
            int temp = a[i] - a[start];
            if (temp < 0) {
                start = i;
                continue;
            }
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * leet:122
     */
    public int maxProfit(int[] a) {
        if (a == null || a.length < 2) {
            return 0;
        }
        int result = 0, curResult = 0, start = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= a[i - 1]) {
                curResult = a[i] - a[start];
            } else {
                start = i;
                result += curResult;
                curResult = 0;
            }
        }
        result += curResult;
        return result;
    }
}
