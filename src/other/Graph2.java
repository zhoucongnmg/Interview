package other;

import java.util.*;

/**
 * A服务依赖B服务，平均调用延迟100ms，记为(A, B, 100)
 * <p>
 * 其他依赖和延迟如下：
 * <p>
 * (A, C, 200)
 * <p>
 * (A, F, 100)
 * <p>
 * (B, D, 100)
 * <p>
 * (D, E, 50)
 * <p>
 * (C, G, 300)
 * <p>
 * 那么服务A有三条调用链：A-B-D-E，A-C-G，A-F，平均延迟250，500，100
 * <p>
 * 延迟最大的调用链是A-C-G，延迟为500ms
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/17
 */
public class Graph2 {
    public static void main(String[] args) {
        Graph2 friendCount = new Graph2();
        Pair pair1 = new Pair('A', 'C', 200);
        Pair pair2 = new Pair('A', 'F', 100);
        Pair pair3 = new Pair('B', 'D', 100);
        Pair pair4 = new Pair('D', 'E', 50);
        Pair pair5 = new Pair('C', 'G', 300);
        List<Pair> list = new ArrayList<>();
        list.add(pair1);
        list.add(pair2);
        list.add(pair3);
        list.add(pair4);
        list.add(pair5);
        friendCount.method(list);
        System.out.println(friendCount.max);
        System.out.println(friendCount.maxPath);
    }

    public void method(List<Pair> input) {
        if (input == null || input.size() == 0) {
            return;
        }
        Map<Character, List<Pair>> map = new HashMap<>(16);
        for (Pair pair : input) {
            List<Pair> items;
            if (map.containsKey(pair.from)) {
                items = map.get(pair.from);
            } else {
                items = new ArrayList<>();
            }
            items.add(pair);
            map.put(pair.from, items);
        }

        for (Map.Entry<Character, List<Pair>> entry : map.entrySet()) {
            List<Character> cur = new ArrayList<>();
            cur.add(entry.getKey());
            maxLen(map, entry.getKey(), 0, cur);
        }

    }

    int max = 0;
    List<Character> maxPath;

    public void maxLen(Map<Character, List<Pair>> map, char from, int curSum, List<Character> curPath) {
        if (!map.containsKey(from)) {
            if (curSum > max) {
                max = curSum;
                maxPath = new ArrayList<>(curPath);
            }
            return;
        }
        List<Pair> list = map.get(from);
        for (Pair pair : list) {
            curPath.add(pair.to);
            maxLen(map, pair.to, curSum + pair.value, curPath);
            curPath.remove(curPath.size() - 1);
        }
    }
}

class Pair {
    char from;
    char to;
    int value;

    public Pair(char from, char to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }
}

