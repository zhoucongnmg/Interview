package stringAndArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class QuanPaiLie {
    public static void main(String[] args) {
        QuanPaiLie qpl = new QuanPaiLie();
        char[] c = {'a', 'b', 'c'};
        qpl.quanPaiLie(c, 0, 2);
    }

    //�ַ���ȫ����
    //�ݹ�ʱע�� �ݹ����
    public void quanPaiLie(char[] a, int start, int end) {
        if (start > end) {
            return;
        }
        if (start == end) {
            for (char c : a) {
                System.out.print(c);
            }
            System.out.println();
        } else {
            Set<Character> set = new HashSet<>();
            for (int i = start; i <= end; i++) {
                //�˴�����
                if (set.contains(a[i])) {
                    continue;
                } else {
                    set.add(a[i]);
                }
                swap(a, start, i);
                quanPaiLie(a, start + 1, end);
                swap(a, start, i);
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
     *
     * @param
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backtracking(combineList, combinations, 1, k, n);
        return combinations;
    }

    private void backtracking(List<Integer> combineList, List<List<Integer>> combinations, int start, int k, final int n) {
        if (k == 0) {
            combinations.add(new ArrayList<>(combineList));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {  // ��֦
            combineList.add(i);
            backtracking(combineList, combinations, i + 1, k - 1, n);
            combineList.remove(combineList.size() - 1);
        }
    }

    //���Ϸǿ��Ӽ� �ǵݹ�
    //ע��
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