package searchAndSort;

/**
 * Ѱ��ȱʧ������
 *
 * @author zc
 */
public class FindLackNum {
    public static void main(String[] args) {
        FindLackNum fl = new FindLackNum();
        int[] a = fl.create(10);
//		int[] b = fl.create(10,11);
        System.out.println(fl.findOne(a));
    }

    //1-100ȱ��һ�����֣�����������ٶ��ҵ�ȱ�ٵ�����
    public int findOne(int[] a) {
        int sum = 0;
        int cur = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        for (int i : a) {
            cur += i;
        }
        return sum - cur;
    }
    //1-100ȱ���������֣�����������ٶ��ҵ�ȱ�ٵ�����
    //a+b=x a*b=y


    public int[] create(int num) {
        int[] a = new int[100];
        int index = 0;
        for (int i = 1; i <= 100; i++) {
            if (i == num) {
                continue;
            }
            a[index++] = i;
        }
        return a;
    }

    public int[] create(int num1, int num2) {
        int[] a = new int[100];
        int index = 0;
        for (int i = 1; i <= 100; i++) {
            if (i == num1 || i == num2) {
                continue;
            }
            a[index++] = i;
        }
        return a;
    }
}