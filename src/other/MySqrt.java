package other;

/**
 * 不用开方符号计算开方
 * @author zc
 *
 */
public class MySqrt {
	
	private final double limit = 0.001;
	
	public static void main(String[] args){
		MySqrt sq = new MySqrt();
		System.out.println(sq.sqrt(100));
		System.out.println(sq.sqrt(0.25));
	}
	
	public Double sqrt(double n){
		if(n < 0)
			return null;
		double start = 0, end = n > 1 ? n : 1;
		double mid = start + (end - start)/2;
		while(Math.abs(mid*mid - n) > limit){
			if(mid*mid > n)
				end = mid;
			else
				start = mid;
			mid = start + (end - start)/2;
				
		}
		return mid;
	}
}
