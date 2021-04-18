package stringAndArray;

/**
 * String��int֮��ת��������
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
     * StringתΪint
     * leet:8
     */
    public Integer stringToInt(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        //ע���漰�ַ���תint�Ķ�Ҫ����long�ݴ棬����ڷ���ǰ�ж��Ƿ�Խ��
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
     * �����ַ�����ӣ��ַ���������������޴�������
     * leet 415
     * ע��
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
            //ע��˴���
            carry = result / 10;
            sb.append(result % 10);
        }
        return sb.reverse().toString();
    }
}
