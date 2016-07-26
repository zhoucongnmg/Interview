package searchAndSort;
import java.util.*;
/**
 * 找出不重复的第一个字符
 * @author zc
 *
 */
public class FindNotDupFirstOne {

	public static void main(String[] args){
		FindNotDupFirstOne f = new FindNotDupFirstOne();
		char[] a = {'a','b','b','a','c','d'};
		char[] b = null;
		System.out.println(f.find(a));
		System.out.println(f.find(b));
	}
	
	public Character find(char[] a){
		if(a == null || a.length == 0)
			return null;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(char c : a){
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
		}
		for(char c : a){
			if(map.get(c) == 1)
				return c;
		}
		return null;
	}
}
