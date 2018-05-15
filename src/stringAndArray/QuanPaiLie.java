package stringAndArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class QuanPaiLie {
    public static void main(String[] args) {
        QuanPaiLie qpl = new QuanPaiLie();
        char[] c = {'a', 'b', 'c'};
        qpl.quanPaiLie(c, 0, 2);
    }

    //字符串全排列
    public void quanPaiLie(char[] a, int start, int end) {

        if (start == end) {
            for (char c : a) {
                System.out.print(c);
            }
            System.out.println();
        } else {
            Set<Character> set = new HashSet<>();
            for (int i = start; i <= end; i++) {
                //此处验重
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

    //集合非空子集 非递归
    public ArrayList<ArrayList<Integer>> getSubsets(int[] a) {
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        if (a == null || a.length == 0) {
            return re;
        }
        //mask = 2的a.length次方减1
        int mask = (1 << a.length) - 1;
        for (int i = mask; i > 0; i--) {
            ArrayList<Integer> list = find(a, i);
            re.add(list);
        }
        return re;
    }

    public ArrayList<Integer> find(int[] a, int mask) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = a.length - 1; i >= 0; i--) {
            if ((mask & (1 << i)) != 0) {
                list.add(a[i]);
            }
        }
        return list;
    }

}