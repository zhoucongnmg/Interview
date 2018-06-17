package stringAndArray;

import java.util.HashMap;
import java.util.Map;


/**
 * 一些字符串方法，高频考点
 *
 * @author zc
 */
public class SomeMethodWithString {

    public static void main(String[] args) {
        SomeMethodWithString sm = new SomeMethodWithString();
        String s = "abcdaaabbcdaeeee";
//        System.out.println(sm.longDupSub(s));
//        System.out.println(sm.longNotDupSub(s));
//        System.out.println(sm.shortEditLen("sailn", "failing"));
//        int[] a = {-2, 11, -4, 13, -5, 2};
//        int[] b = {1, -3, 4, -2, -1, 6};
//        System.out.println(sm.maxSum(a));
//        System.out.println(sm.maxSum(b));

//        System.out.println(sm.longestSameSubString("vvsenk", "jvvenksssssss"));
        System.out.println(sm.longestSameSubXulie("abcdef", "zbhdf"));
        System.out.println(sm.zuiChangHuiWen("babcbabcbaccba"));

        int[] c = {6, 7, 3, 4, 5, 5, 1, 2};
        int[] result = sm.longestIncreaseSub(c);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * 最长重复子串
     */
    public String longDupSub(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int maxStart = 0, maxLen = 1;
        int curStart = 0, curLen = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                curLen = 1;
                curStart = i;
            }
            if (curLen > maxLen) {
                maxLen = curLen;
                maxStart = curStart;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    /**
     * 最长不重复子串
     * <p>
     * 注意
     */
    public String longNotDupSub(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int maxStart = 0, maxLen = 1;
        int curStart = 0, curLen = 0;
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                curLen++;
            } else {
                //下面两行代码是重点好吧 abbefa    abcada
                curStart = Math.max(map.get(c) + 1, curStart);
                curLen = i - curStart + 1;
            }
            if (curLen > maxLen) {
                maxLen = curLen;
                maxStart = curStart;
            }
            map.put(c, i);
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    /**
     * 最短编辑距离设A和B是2个字符串。要用最少的字符操作将字符串A转换为字符串B。这里所说的字符操作包括:
     * (1)删除一个字符;
     * (2)插入一个字符；
     * (3)将一个字符改为另一个字符。
     * dp[i][j]它表示第一个字符串的长度为i的子串到第二个字符串的长度为j的子串的最短编辑距离。
     */
    public int shortEditLen(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return -1;
        }
        if (s1 == null) {
            return s2.length();
        }
        if (s2 == null) {
            return s1.length();
        }
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int delete, insert, update;
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                delete = dp[i - 1][j] + 1;
                insert = dp[i][j - 1] + 1;
                //此处需注意，为s1.charAt(i-1)
                update = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(update, Math.min(delete, insert));
            }
        }
        return dp[len1][len2];
    }

    /**
     * 最大连续子序列和问题
     */
    public int maxSum(int[] a) {
        if (a == null) {
            return -1;
        }
        if (a.length == 0) {
            return 0;
        }
        int curStart = 0, curSum = 0;
        int maxStart = 0, maxSum = 0, maxEnd = 0;
        for (int i = 0; i < a.length; i++) {
            curSum += a[i];
            if (curSum > maxSum) {
                maxStart = curStart;
                maxSum = curSum;
                maxEnd = i;
            } else if (curSum < 0) {
                curStart = i + 1;
                curSum = 0;
            }
        }
        System.out.println("起始点为 " + maxStart + "终止点为 " + maxEnd);
        return maxSum;
    }

    /**
     * 最长公共子串，要求连续
     * http://www.cnblogs.com/zhangchaoyang/articles/2012070.html
     */
    public String longestSameSubString(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return null;
        }
        if (s1.length() == 0 || s2.length() == 0) {
            return "";
        }

        int len1 = s1.length(), len2 = s2.length();
        int[] dp0 = new int[len2 + 1];
        int[] dp1 = new int[len2 + 1];
        int maxEnd = 0, maxLen = 0;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp1[j] = dp0[j - 1] + 1;
                } else {
                    dp1[j] = 0;
                }
                if (dp1[j] > maxLen) {
                    maxLen = dp1[j];
                    maxEnd = j - 1;
                }
            }
            //注意此处不能直接dp = temp ，这样他俩就指向同一地址，我们要的是两个数组值赋值
            System.arraycopy(dp1, 0, dp0, 0, len2 + 1);
        }
        return s2.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    /**
     * 最长公共子序列，不要求连续
     */
    public String longestSameSubXulie(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return null;
        }
        if (s1.length() == 0 || s2.length() == 0) {
            return "";
        }
        int len1 = s1.length(), len2 = s2.length();
        //dp[i][j]表示s1的前i位和s2的前j位两个子串的最长公共子序列，所以逐步求到dp[i][j]即为所求
        int[][] dp = new int[len1 + 1][len2 + 1];

        StringBuilder sb = new StringBuilder();
        int maxCount = 0;

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if(dp[i][j] > maxCount){
                    maxCount = dp[i][j];
                    sb.append(s1.charAt(i-1));
                }
            }
        }
        return sb.toString();
    }

    /**
     * 最长回文子串 aba或abba
     */
    public String zuiChangHuiWen(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        String max = "", s1 = null, s2 = null;
        for (int i = 0; i < s.length(); i++) {
            s1 = getHuiWenByBit(s, i, i);
            s2 = getHuiWenByBit(s, i, i + 1);
            s1 = s1.length() > s2.length() ? s1 : s2;
            if (s1.length() > max.length()) {
                max = s1;
            }
        }
        return max;
    }

    //逐位获取回文子串
    public String getHuiWenByBit(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    /**
     * 最长递增子序列
     * 注意
     */

    public int[] longestIncreaseSub(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int[] temp = new int[a.length];
        int[] dp = new int[a.length];  //dp[i]表示以a[i]为结尾的最长递增子序列长度
        int len = 0; //表示temp中元素个数
        for (int i = 0; i < a.length; i++) {
            int j = binarySearch(temp, 0, len - 1, a[i]);
            temp[j] = a[i];
            dp[i] = j + 1;
            if (j + 1 > len) {
                len = j + 1;
            }
        }

        return getResult(a, dp, len);
    }

    public int binarySearch(int[] a, int start, int end, int k) {
        if (start > end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (a[mid] == k) {  //此处注意，根据数组中相同值得不同处理 有不同的方案，具体问面试官
            return mid;
        } else if (a[mid] > k) {
            return binarySearch(a, start, mid - 1, k);
        } else {
            return binarySearch(a, mid + 1, end, k);
        }
    }

    public int[] getResult(int[] a, int[] dp, int len) {
        int[] result = new int[len];
        int before = Integer.MAX_VALUE;
        int index = len - 1;
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] == index + 1 && a[i] < before) {
                result[index--] = a[i];
                before = a[i];
            }
            if (index < 0) {
                break;
            }
        }
        return result;
    }

}
