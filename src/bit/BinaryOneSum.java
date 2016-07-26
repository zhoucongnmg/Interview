package bit;
/**
 * 一个数的二进制里面1的个数
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
	}
}
