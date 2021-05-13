package bit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * һ�����Ķ���������1�ĸ���
 * @author zc
 *
 */
public class BinaryOneSum {
	public int getOneSum(int i){
		int sum = 0;
		while(i != 0){
			i = i & (i-1);
			sum++;
		}
		return sum;
	}
	
	public static void main(String[] args){
		BinaryOneSum bos = new BinaryOneSum();
		System.out.println(bos.getOneSum(10));
		Scanner in = new Scanner(System.in);
		List<Integer> input = new ArrayList<>();
		while (true){
			int a = in.nextInt();
			if (a == -1){
				break;
			}
			input.add(a);
		}
		System.out.println(input);

	}
}
