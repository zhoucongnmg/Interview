package stringAndArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class QuanPaiLie {
    private static List<List<Character>> result = new ArrayList<>();

    public static void main(String[] args) {
        QuanPaiLie qpl = new QuanPaiLie();
        char[] c = {'a', 'b', 'c'};
        List<Character> cur = new ArrayList<>();
        qpl.quanPaiLie(c, 0, 2, cur);
        System.out.println(result);
        System.out.println(combine(4, 2));
    }


    /**
     * 字符串全排列,leet:47, 注意
     *
     * @param a
     * @param start
     * @param end
     * @param cur
     */
    public void quanPaiLie(char[] a, int start, int end, List<Character> cur) {
        if (start == end) {
            //此处注意，cur.add和cur.remove必须成对出现，
            List<Character> curResult = new ArrayList<>(cur);
            curResult.add(a[start]);
            result.add(curResult);
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            //此处验重
            if (!set.contains(a[i])) {
                set.add(a[i]);
                swap(a, start, i);
                cur.add(a[start]);
                quanPaiLie(a, start + 1, end, cur);
                swap(a, start, i);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * leecode：77. 组合
     * 注意
     *
     * @param
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        if (k > n) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curResult = new ArrayList<>();
        backtracking(curResult, result, 1, k, n);
        return result;
    }

    private static void backtracking(List<Integer> cur, List<List<Integer>> result, int start, int k, int end) {
        //注意千万不能带start>end,否则会过滤掉最后一位，重新写一下
//        if (start > end) {
//            return;
//        }
        if (k == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (start > end) {
            return;
        }
        for (int i = start; i <= end - k + 1; i++) {
            cur.add(i);
            backtracking(cur, result, i + 1, k - 1, end);
            cur.remove(cur.size() - 1);
        }
    }


    /**
     * 集合非空子集 非递归,没有重复元素的时候使用这个方法
     * 注意
     *
     * @param a
     * @return
     */
    public List<List<Integer>> getSubsets(int[] a) {
        List<List<Integer>> re = new ArrayList<>();
        if (a == null || a.length == 0) {
            return re;
        }
        //mask = 2的a.length次方减1
        int mask = (1 << a.length) - 1;
        for (int i = mask; i > 0; i--) {
            List<Integer> list = find(a, i);
            re.add(list);
        }
        return re;
    }

    public List<Integer> find(int[] a, int mask) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int shift = a.length - i - 1;
            if ((mask & (1 << shift)) != 0) {
                list.add(a[i]);
            }
        }
        return list;
    }
}