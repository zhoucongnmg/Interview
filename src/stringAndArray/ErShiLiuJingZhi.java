package stringAndArray;

/**
 * //����A��B��...��Z��AA��AB��...��ZZ��AAA �����У������ַ����������
 *
 * @author zc
 */
public class ErShiLiuJingZhi {

    public static void main(String[] args) {
        ErShiLiuJingZhi esl = new ErShiLiuJingZhi();
        System.out.println(esl.convert("Z"));
        System.out.println(esl.convert2("Z"));
        System.out.println(esl.convert("BA"));
        System.out.println(esl.convert2("BA"));
        System.out.println(esl.convert("AAA"));
        System.out.println(esl.convert2("AAA"));
    }

    public int convert(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            //ע���쳣���
            if (!Character.isUpperCase(c)) {
                return -1;
            }
            //�˴���Ҫע�⣬Math��pow���ص�Ϊdouble����ҪתΪint
            sum = sum + (c - 'A' + 1) * (int) Math.pow(26, s.length() - 1 - i);
        }
        return sum;
    }

    //��ѡ���ַ���
    public int convert2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isUpperCase(c)) {
                return -1;
            }
            sum = sum * 26 + (c - 'A' + 1);
        }
        return sum;
    }
}
