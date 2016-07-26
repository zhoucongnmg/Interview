package stringAndArray;

/**
 * String±È½Ï
 * @author zc
 *
 */
public class StringCompare {

	public static void main(String[] args){
		String a = "abc"; 
		String b = "abc";
		String c = new String("abc");
		String d = "ab" + "c";
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a == d);
	}
	
}
