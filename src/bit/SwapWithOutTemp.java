package bit;

import java.util.Arrays;

/**
 * 不使用第三个数（临时变量）交换两个整形数
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

    //缺点，会溢出
    public int[] swap(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        array[0] = array[0] + array[1];
        array[1] = array[0] - array[1];
        array[0] = array[0] - array[1];
        return array;
    }

    //任何数和自己异或为0，和0异或为其本身
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
