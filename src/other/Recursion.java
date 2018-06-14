package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归算法
 */
public class Recursion {
    public static void main(String[] args) {
        // jump(0,10,new ArrayList<Integer>());
        rank(0, 0, new ArrayList<Integer>());
    }

    //青蛙跳台阶打印所有路径
    public static void jump(int cur, int sum, List<Integer> list) {
        if (cur > sum) {
            return;
        }
        if (cur == sum) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
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

    public static void rank(int boy, int gril, List<Integer> list) {
        //注意此处的校验条件
        if (boy > gril || list.size() > n) {
            return;
        }
        if (list.size() == n && boy == gril) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        list.add(1);
        rank(boy + 1, gril, list);
        list.remove(list.size() - 1);
        list.add(0);
        rank(boy, gril + 1, list);
        list.remove(list.size() - 1);
    }
}