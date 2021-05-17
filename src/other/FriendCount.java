package other;

import java.util.*;

/**
 * 返回朋友圈个数，A-B、B-C、D-E、E-F  则abc为一个朋友圈  def为一个朋友圈 返回2
 * TODO
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/17
 */
public class FriendCount {
    public static void main(String[] args) {
        FriendCount friendCount = new FriendCount();
        List<Character> l1 = new ArrayList<>();
        l1.add('A');
        l1.add('B');
        List<Character> l2 = new ArrayList<>();
        l2.add('B');
        l2.add('C');
        List<Character> l3 = new ArrayList<>();
        l3.add('D');
        l3.add('E');
        List<Character> l4 = new ArrayList<>();
        l4.add('E');
        l4.add('F');
        List<List<Character>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        System.out.println(friendCount.method(list));
    }

    public int method(List<List<Character>> input) {
        if (input == null || input.size() == 0) {
            return 0;
        }
        Map<Character, Set<Character>> map = new HashMap<>(16);
        int sum = 0;
        for (List<Character> item : input) {
            char c1 = item.get(0);
            char c2 = item.get(1);
            Set<Character> set1 = null;
            Set<Character> set2 = null;
            if (map.containsKey(c1)) {
                set1 = map.get(c1);
            } else {
                set1 = new HashSet<>();
            }
            if (map.containsKey(c2)) {
                set2 = map.get(c2);
            } else {
                set2 = new HashSet<>();
            }
            if (set1.size() == 0 && set2.size() == 0) {

            }
            set1.addAll(set2);
            set2.addAll(set1);
            map.put(c1, set1);
            map.put(c2, set2);
        }

        Set<Character> set = new HashSet<>();
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            List<Character> value = new ArrayList<>(entry.getValue());
            if (!set.contains(value.get(0))) {
                sum++;
                set.addAll(value);
            }
        }
        return sum;
    }
}
