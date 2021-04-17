package other;

public class LeetCode121 {

    /**
     * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
     * ��������ֻ�������һ�ʽ��ף������������һ֧��Ʊ�������һ���㷨�����������ܻ�ȡ���������
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
     * ����һ�����飬���ĵ� i ��Ԫ����һ֧������Ʊ�� i ��ļ۸�
     * ���һ���㷨�����������ܻ�ȡ�������������Ծ����ܵ���ɸ���Ľ��ף��������һ֧��Ʊ����
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
