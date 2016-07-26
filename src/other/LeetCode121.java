package other;

public class LeetCode121 {

	public int method(int[] a){
		if(a == null)
			return -1;
		int max = 0;
		int start = 0;
		for(int i=0;i<a.length;i++){
			int temp = a[i] - a[start];
			if(temp < 0){
				start = i;
				continue;
			}
			if(temp > max)
				max = temp;
		}
		return max;
	}
}
