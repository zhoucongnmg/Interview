package bit;

/**
 * 不使用第三个数（临时变量）交换两个整形数
 * @author zc
 *
 */
public class SwapWithOutTemp {

	public static void main(String[] args){
		SwapWithOutTemp sw = new SwapWithOutTemp();
		sw.swap(1,2);
		sw.swap2(1,2);
	}
	
	//缺点，会溢出
	public void swap(int a,int b){
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a:"+a+" b:"+b);
	}
	
	//任何数和自己异或为0，和0异或为其本身
	public void swap2(int a,int b){
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a:"+a+" b:"+b);
	}
}
