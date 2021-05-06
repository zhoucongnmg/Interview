package stringAndArray;

import java.util.*;

/**
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/3
 */
public class Jiaoji {

    public static void main(String[] args) {
        int[] a1 = new int[]{4, 9, 4, 5};
        int[] a2 = new int[]{9, 4, 9, 8, 4};
        Jiaoji jiaoji = new Jiaoji();
        System.out.println(jiaoji.intersect3(a1, a2));
    }

    /**
     * ���������󽻼��������в����ظ���leet349
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public List<Integer> intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                set.remove(i);
                result.add(i);
            }
        }
        return result;
    }

    /**
     * ���������󽻼���leet350
     * ��������ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ִ�������Сֵһ�¡�
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public List<Integer> intersect2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                if (count > 0) {
                    result.add(i);
                    map.put(i, count - 1);
                }
            }
        }
        return result;
    }

    /**
     * �󽻼�������������
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public List<Integer> intersect3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                j++;
                continue;
            }
            result.add(nums1[i]);
            i++;
            j++;
        }
        return result;
    }
}
