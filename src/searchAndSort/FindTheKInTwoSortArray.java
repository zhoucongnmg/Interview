package searchAndSort;

/**
 * 两个有序数组，找出第k大的元素
 * @author zc
 *
 */
public class FindTheKInTwoSortArray {
	
	public static void main(String[] args){
		int[] a = {1,3,5,7};
		int[] b = {2,4};
		int[] c = {8,9};
		FindTheKInTwoSortArray ft = new FindTheKInTwoSortArray();
		System.out.println(ft.find(a,b,6));
		System.out.println(ft.find(a,b,2));
		System.out.println(ft.find(a,c,3));
	}

	public Integer find(int[] a,int[] b,int k){
		
		//注意此处的校验
		if(a == null && b == null)
			return null;
		if(a == null)
			return b.length >= k ? b[k-1]:null;
		if(b == null)
			return a.length >= k ? a[k-1]:null;
		if(a.length + b.length < k)
			return null;
		
		int i=a.length-1,j=b.length-1;
		int temp = 0;
		while(i>=0 && j>=0){
			k--;
			if(a[i] > b[j]){
				temp = a[i];
				i--;
			}
			else{
				temp = b[j];
				j--;
			}
			if(k == 0)
				return temp;
		}
		if(i>=0)
			return a[i-k+1];
		else
			return b[j-k+1];
	}
}
