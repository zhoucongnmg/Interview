package stringAndArray;

/**
 * È«ÅÅÁÐ
 * @author zc
 *
 */
public class QuanPaiLie {
	
	public static void main(String[] args){
		QuanPaiLie qpl = new QuanPaiLie();
		char[] c = {'a','b','c'};
		qpl.quanPailie(c,0,2);
	}
	
	public void quanPailie(char[] a,int start,int end){
		if(start == end)
			printArray(a);
		else{
			for(int i=start;i<=end;i++){
				swap(a,start,i);
				quanPailie(a,start+1,end);
				swap(a,start,i);
			}
		}
	}
	
	public void printArray(char[] a){
		for(char c : a)
			System.out.print(c+" ");
		System.out.println();
	}
	
	public void swap(char[] a,int i,int j){
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
