package stringAndArray;

/**
 * //按照A、B、...、Z、AA、AB、...、ZZ、AAA 的序列，给出字符串返回序号
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
            //注意异常情况
            if (!Character.isUpperCase(c)) {
                return -1;
            }
            //此处需要注意，Math。pow返回的为double，需要转为int
            sum = sum + (c - 'A' + 1) * (int) Math.pow(26, s.length() - 1 - i);
        }
        return sum;
    }

    //首选这种方法
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
