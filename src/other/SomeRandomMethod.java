package other;

/**
 * ������������
 * @author zc
 *
 */
public class SomeRandomMethod {

	public static void main(String[] args){
		
		double x = 3.0;
		int y =5;
		x/=--y;
		System.out.println(x);
	}
	/**
	 * ��ˮ�س�������
	 * ������100��������Ҫѡ10����������ÿ����ѡ�����ĸ���Ҫ�Ǿ��ȡ�
	 * ������a�������ȡn������Ҫ��ÿ�������鵽�ĸ�����ͬ
	 */
	public int[] xuShuiChiChouYang(int[] a,int n){
		if(a == null)
			return null;
		if(a.length < n)
			return null;
		int[] result = new int[n];
		for(int i=0;i<a.length;i++){
			if(i<n)
				result[i] = a[i];
			else{
				//1��ע��˴������д�� 2����Ҫע��ת��Ϊint 3��ע��һ��Ҫ�Ƚ��������������������һֱΪ0
				int ran = (int)(Math.random()*(i+1));
				if(ran < n)
					result[ran] = a[i];
			}
		}
		return result;
	}
	
	/**
	 * ���ϴ������
	 * ������a���ϴ��
	 */
	public void suiJiXiPai(int[] a){
		if(a == null)
			return;
		int ran = 0;
		for(int i=a.length-1;i>=0;i--){
			ran = (int)(Math.random()*(i+1));
			swap(a,ran,i);
		}
	}
	
	public void swap(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
