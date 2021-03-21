package stringAndArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 一组字符串，按出现的次数排序
 *
 * @author zc
 */
public class SortByTime {

    public static void main(String[] args) {
        SortByTime sbt = new SortByTime();

        String[] s = {"a", "b", "b", "c", "c", "c"};
        System.out.println(sbt.sortByTime(s).toString());
    }

    public List<Map.Entry<String, Integer>> sortByTime(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : a) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1, e2) -> e2.getValue() - e1.getValue());

        return list;
    }
}
