package bit;

/**
 * ��ʹ�õ�����������ʱ��������������������
 * @author zc
 *
 */
public class SwapWithOutTemp {

	public static void main(String[] args){
		SwapWithOutTemp sw = new SwapWithOutTemp();
		sw.swap(1,2);
		sw.swap2(1,2);
	}
	
	//ȱ�㣬�����
	public void swap(int a,int b){
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a:"+a+" b:"+b);
	}
	
	//�κ������Լ����Ϊ0����0���Ϊ�䱾��
	public void swap2(int a,int b){
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a:"+a+" b:"+b);
	}
}
