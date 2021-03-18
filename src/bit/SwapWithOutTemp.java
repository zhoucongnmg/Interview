package bit;

import java.util.Arrays;

/**
 * ��ʹ�õ�����������ʱ��������������������
 *
 * @author zc
 */
public class SwapWithOutTemp {

    public static void main(String[] args) {
        SwapWithOutTemp sw = new SwapWithOutTemp();
        int[] array = new int[]{1, 2};
        int[] array2 = new int[]{1, 2};
        System.out.println(Arrays.toString(sw.swap(array)));
        System.out.println(Arrays.toString(sw.swap2(array2)));
    }

    //ȱ�㣬�����
    public int[] swap(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        array[0] = array[0] + array[1];
        array[1] = array[0] - array[1];
        array[0] = array[0] - array[1];
        return array;
    }

    //�κ������Լ����Ϊ0����0���Ϊ�䱾��
    public int[] swap2(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        array[0] = array[0] ^ array[1];
        array[1] = array[0] ^ array[1];
        array[0] = array[0] ^ array[1];
        return array;
    }
}
