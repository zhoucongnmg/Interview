package searchAndSort;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出出现次数最多的数字
 *
 * @author zc
 */
public class FindMostTimes {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 5};
        FindMostTimes fm = new FindMostTimes();
        try {
            System.out.println(fm.find(a));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Integer find(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int max = a[0];
        int maxTimes = 0;
        Map<Integer, Integer> map = new HashMap<>(a.length);
        for (int i : a) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
            if (map.get(i) > maxTimes) {
                maxTimes = map.get(i);
                max = i;
            }
        }
        return max;
    }
}
