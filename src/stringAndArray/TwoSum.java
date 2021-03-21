package stringAndArray;

import java.util.*;


public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] a = {1, 2, 3, 4, 5};
        List<List<Integer>> list = twoSum.kSum(a, 4, 10);
        System.out.println(list.toString());
    }

    /**
     * leecode:167
     * 两个数的和为指定值 有序
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int[] re = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                re[0] = i;
                re[1] = j;
                break;
            }
        }
        return re;
    }

    /**
     * leetcode:1
     * 两个数的和，无序
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        int[] a = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                a[0] = i;
                a[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return a;
    }

    /**
     * leetcode:15
     * 三个数的和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<>();
        //i后面至少留两个数
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int m = i + 1, n = nums.length - 1;
            while (m < n) {
                if (nums[i] + nums[n] + nums[m] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[m]);
                    list.add(nums[n]);
                    returnList.add(list);
                    m++;
                    n--;
                    while (m < n && nums[m] == nums[m - 1]) {
                        m++;
                    }
                    while (m < n && nums[n] == nums[n + 1]) {
                        n--;
                    }
                    //list.add(Arrays.asList(nums[i],nums[m],nums[n]));
                } else if (nums[i] + nums[n] + nums[m] < 0) {
                    m++;
                } else {
                    n--;
                }
            }
        }
        return returnList;
    }

    /**
     * 四个数和，从而引申到k个数和
     * @param a
     * @param k
     * @param sum
     * @return
     */
    public List<List<Integer>> kSum(int[] a, int k, int sum) {
        Arrays.sort(a);
        if (a == null || a.length < k) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        kSum(a, k, 0, a.length - 1, sum, new ArrayList<>(), result);
        return result;
    }

    private void kSum(int[] a, int k, int start, int end, int sum, List<Integer> cur, List<List<Integer>> result) {
        if (end - start + 1 < k) {
            return;
        }
        if (k == 2) {
            int i = start, j = end;
            while (i < j) {
                if (a[i] + a[j] == sum) {
                    cur.add(a[i]);
                    cur.add(a[j]);
                    List<Integer> sub = new ArrayList<>(cur);
                    result.add(sub);
                    i++;
                    j--;
                    while (i < j && a[i] == a[i - 1]) {
                        i++;
                    }
                    while (i < j && a[j] == a[j + 1]) {
                        j--;
                    }
                } else if (a[i] + a[j] < sum) {
                    i++;
                } else {
                    j--;
                }
            }
        } else {
            for (int i = start; i <= end - k + 1; i++) {
                cur.add(a[i]);
                kSum(a, k - 1, i + 1, end, sum - a[i], cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }
}