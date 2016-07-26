package stringAndArray;

/**
 * 给一串字符串比如abbbcccd，输出a1b3c3d1，手写代码
 * @author zc
 *
 */
public class CharSum {
	
	public static void main(String[] args){
		CharSum cs = new CharSum();
		System.out.println(cs.compute("abbbcccd"));
	}
	
	public String compute(String s){
		if(s == null || s.length() == 0)
			return s;
		StringBuilder sb = new StringBuilder();
		int charSum = 1;
		for(int i=1;i<s.length();i++){
			if(s.charAt(i) == s.charAt(i-1))
				charSum++;
			else{
				//千万不要这么拼，否则char和int做加法转换为int
//				sb.append(s.charAt(i-1) + charSum);
				sb.append(s.charAt(i-1));
				sb.append(charSum);
				charSum = 1;
			}
		}
//		sb.append(s.charAt(s.length()-1) + charSum);
		sb.append(s.charAt(s.length()-1));
		sb.append(charSum);
		return sb.toString();
	}
}
