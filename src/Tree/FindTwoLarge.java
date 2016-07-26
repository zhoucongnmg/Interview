package Tree;

/**
 * 找出第二大的数字
 * @author zc
 *
 */
public class FindTwoLarge {
	
	public static void main(String[] args){
		FindTwoLarge fd = new FindTwoLarge();
		int[] a = {5,4,3,2,1,7,8,9};
		System.out.println(fd.find(a));
	}
	
	public Integer find(int[] a){
		if(a == null || a.length < 2)
			return null;
		int max1,max2;
		if(a[0] > a[1]){
			max1 = a[0];
			max2 = a[1];
		}
		else{
			max1 = a[1];
			max2 = a[2];
		}
		for(int i=2;i<a.length;i++){
			if(a[i] > max1){
				max2 = max1;
				max1 = a[i];
			}
			else if(a[i] > max2)
				max2 = a[i];
		}
		return max2;
	}
}
