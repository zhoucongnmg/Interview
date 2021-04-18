package stringAndArray;

/**
 * String和int之间转换或运算
 *
 * @author zc
 */
public class StringToInt {


    public static void main(String[] args) {
        StringToInt sti = new StringToInt();
        System.out.println(sti.stringToInt("123456"));
        System.out.println(sti.addTwoString("99999", "111"));
    }

    /**
     * String转为int
     * leet:8
     */
    public Integer stringToInt(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        //注意涉及字符串转int的都要先用long暂存，最后在返回前判断是否越界
        long sum = 0;
        int start = 0;
        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
            start++;
        } else if (s.charAt(0) == '+') {
            sign = 1;
            start++;
        }
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return (int) (sum * sign);
            }
            sum = sum * 10 + (c - '0');
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (sum * sign) < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (sum * sign);
    }

    /**
     * 两个字符串相加（字符串代表的数字无限大会溢出）
     * leet 415
     * 注意
     */
    public String addTwoString(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0, result = 0;
        StringBuilder sb = new StringBuilder();
        int val1 = 0, val2 = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                val1 = a.charAt(i) - '0';
                i--;
            } else {
                val1 = 0;
            }
            if (j >= 0) {
                val2 = b.charAt(j) - '0';
                j--;
            } else {
                val2 = 0;
            }
            result = val1 + val2 + carry;
            //注意此处，
            carry = result / 10;
            sb.append(result % 10);
        }
        return sb.reverse().toString();
    }
}
