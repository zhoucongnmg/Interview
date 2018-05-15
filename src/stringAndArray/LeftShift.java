package stringAndArray;

/**
 * ѭ����λ
 *
 * @author zc
 */
public class LeftShift {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        LeftShift lf = new LeftShift();
        lf.leftShift(a, 3);
        for (int i : a) {
            System.out.println(i);
        }
        System.out.println(lf.leftShift2("12345", 3));
        System.out.println(lf.isContains("abcd", "cda"));
    }

    /**
     * ��������
     */
    public void leftShift(int[] a, int k) {
        if (a == null || a.length < 2) {
            return;
        }
        k = k % a.length;
        int[] temp = new int[k];
        System.arraycopy(a, 0, temp, 0, k);
        System.arraycopy(a, k, a, 0, a.length - k);
        System.arraycopy(temp, 0, a, a.length - k, k);

    }

    /**
     * �����ַ���
     */
    public String leftShift2(String s, int k) {
        if (s == null || s.length() < 2) {
            return s;
        }
        k = k % s.length();
        String right = s.substring(0, k);
        String left = s.substring(k);
        return left + right;
    }

    /**
     * �ж�����һ���ַ����ǲ�����һ���ַ����������Ӵ�����cda��abcd�������Ӵ���
     */
    public boolean isContains(String s, String sub) {
        if (s == null || sub == null) {
            return false;
        }
        s += s;
        return s.contains(sub);
    }
}
