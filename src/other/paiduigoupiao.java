package other;

/**
 * @author zhoucong
 * @time 2018/5/17
 * 1����Ʊ�������ڽ��У�ÿ��ƱΪ50Ԫ��������m+n���Ŷӵȴ���Ʊ��������m���ֳ�50Ԫ��n���ֳ�100
 * Ԫ��������Ʊ���������㣬��ô����ʹ��Ʊ����������Ҳ�����Ǯ�ľ��棬�����æ��Ʋ�ͬ���Ŷӷ������ر�˵�����ǣ���ͬ����ֵ���˶Ի�λ��Ϊͬһ�ַ�����
 * <p>
 * 2����Ů�Ŷ�����
 * m��������n��Ů�� Ҫ������λ��ǰ ������Ů����,���ж������Ŷӷ���
 *
 * https://blog.csdn.net/hyperprogram/article/details/60970520
 */
public class paiduigoupiao {
    private int f(int m, int n) {
        if (m < n) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return f(m - 1, n) + f(m, n - 1);
    }
}


