package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归算法
 * 注意
 */
public class Recursion {
    static List<List<Integer>> jumpResult = new ArrayList<>();
    static List<List<Integer>> rankResult = new ArrayList<>();

    public static void main(String[] args) {
        jump(0, 10, new ArrayList<>());
        System.out.println(jumpResult);
        rank(0, 0, 5, 5, new ArrayList<>());
        System.out.println(rankResult);
    }

    //青蛙跳台阶打印所有路径
    public static void jump(int cur, int sum, List<Integer> list) {
        //注意此处，可能溢出
        if (cur > sum) {
            return;
        }
        if (cur == sum) {
            List<Integer> path = new ArrayList<>(list);
            jumpResult.add(path);
            return;
        }
        list.add(1);
        jump(cur + 1, sum, list);
        list.remove(list.size() - 1);
        list.add(2);
        jump(cur + 2, sum, list);
        list.remove(list.size() - 1);
    }

    //男孩女孩排队，男女孩都为n/2，要求任意位置i前面，女孩数都大于男孩数,打印所有可能情况
    static int n = 10;

    public static void rank(int boy, int girl, int boyLimit, int girlLimit, List<Integer> list) {
        //注意此处的校验条件
        if (boy > girl || list.size() > boyLimit + girlLimit) {
            return;
        }
        if (list.size() == boyLimit + girlLimit && boy == girl) {
            List<Integer> path = new ArrayList<>(list);
            rankResult.add(path);
            return;
        }
        list.add(1);
        rank(boy + 1, girl, boyLimit, girlLimit, list);
        list.remove(list.size() - 1);
        list.add(0);
        rank(boy, girl + 1, boyLimit, girlLimit, list);
        list.remove(list.size() - 1);
    }
}