package other;

/**
 * @author zhoucong
 * @time 2018/5/17
 */
public class paiduigoupiao {
    /**
     * ע��
     * <p>
     * 1����Ʊ�������ڽ��У�ÿ��ƱΪ50Ԫ��������m+n���Ŷӵȴ���Ʊ��������m���ֳ�50Ԫ��n���ֳ�100
     * Ԫ��������Ʊ���������㣬��ô����ʹ��Ʊ����������Ҳ�����Ǯ�ľ��棬�����æ��Ʋ�ͬ���Ŷӷ������ر�˵�����ǣ���ͬ����ֵ���˶Ի�λ��Ϊͬһ�ַ�����
     * <p>
     * 2����Ů�Ŷ�����
     * m��������n��Ů�� Ҫ������λ��ǰ ������Ů����,���ж������Ŷӷ���
     * <p>
     * https://blog.csdn.net/hyperprogram/article/details/60970520
     *
     * @param m
     * @param n
     * @return
     */
    private int f(int m, int n) {
        if (m < n) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return f(m - 1, n) + f(m, n - 1);
    }

    /**
     * leet:860. ����ˮ����
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }
        int fives = 0, tens = 0;
        for (int i : bills) {
            if (i == 5) {
                fives++;
                continue;
            }
            if (i == 10) {
                if (fives > 0) {
                    fives--;
                    tens++;
                } else {
                    return false;
                }
                continue;
            }
            if (i == 20) {
                if (tens > 0) {
                    tens--;
                    if (fives > 0) {
                        fives--;
                    } else {
                        return false;
                    }
                } else {
                    if (fives >= 3) {
                        fives -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


