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
        System.out.println(combine(4,2));
    }


    /**
     * �ַ���ȫ����,leet:47, ע��
     *
     * @param a
     * @param start
     * @param end
     * @param cur
     */
    public void quanPaiLie(char[] a, int start, int end, List<Character> cur) {
        if (start == end) {
            //�˴�ע�⣬cur.add��cur.remove����ɶԳ��֣�
            List<Character> curResult = new ArrayList<>(cur);
            curResult.add(a[start]);
            result.add(curResult);
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            //�˴�����
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
     * leecode��77. ���
     * ע��
     * @param
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backtracking(combineList, combinations, 1, k, n);
        return combinations;
    }

    private static void backtracking(List<Integer> combineList, List<List<Integer>> combinations, int start, int k, int end) {
        //ע��ǧ���ܴ�start>end,�������˵����һλ
//        if (start > end) {
//            return;
//        }
        if (k == 0) {
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        for (int i = start; i <= end; i++) {
            combineList.add(i);
            backtracking(combineList, combinations, i + 1, k - 1, end);
            combineList.remove(combineList.size() - 1);
        }
    }


    /**
     * ���Ϸǿ��Ӽ� �ǵݹ�,û���ظ�Ԫ�ص�ʱ��ʹ���������
     *
     * @param a
     * @return
     */
    public List<List<Integer>> getSubsets(int[] a) {
        List<List<Integer>> re = new ArrayList<>();
        if (a == null || a.length == 0) {
            return re;
        }
        //mask = 2��a.length�η���1
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