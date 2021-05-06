package searchAndSort;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出不重复的第一个字符
 *
 * @author zc
 */
public class FindNotDupFirstOne {

    public static void main(String[] args) {
        FindNotDupFirstOne f = new FindNotDupFirstOne();
        char[] a = {'a', 'b', 'b', 'a', 'c', 'd'};
        char[] b = null;
        System.out.println(f.find(a));
        System.out.println(f.find(b));
    }

    public Character find(char[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        Map<Character, Boolean> map = new HashMap<>(16);
        for (char c : a) {
            if (map.containsKey(c)) {
                map.put(c, true);
            } else {
                map.put(c, false);
            }
        }
        for (char c : a) {
            if (!map.get(c)) {
                return c;
            }
        }
        return null;
    }
}
