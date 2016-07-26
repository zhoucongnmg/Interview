package stringAndArray;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * һ���ַ����������ֵ�˳������
 * @author zc
 *
 */
public class SortByTime {

	public static void main(String[] args){
		SortByTime sbt = new SortByTime();

		String[] s = {"a","b","b","c","c","c"};
		sbt.sortByTime(s);
	}
	
	public void sortByTime(String[] a){
		if(a == null || a.length == 0)
			return;
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(String s : a){
			if(map.containsKey(s))
				map.put(s,map.get(s)+1);
			else
				map.put(s,1);
		}
		List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
			public int compare(Map.Entry<String,Integer> e1,Map.Entry<String,Integer> e2){
				return e2.getValue() - e1.getValue(); 
			}
		});
		
		System.out.print(list);
	}
}
