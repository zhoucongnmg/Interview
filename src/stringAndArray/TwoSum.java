package stringAndArray;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {

    }

    //两个数的和为指定值 有序
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

    //两个数的和，无序
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

    //三个数的和，不看
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
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

    //四个数和，从而引申到k个数和，叹为观止，不用看
    int len = 0;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (index >= len) {
            return res;
        }
        if (k == 2) {
            int i = index, j = len - 1;
            while (i < j) {
                //find a pair
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target - nums[i]);
                    res.add(temp);
                    //skip duplication
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j - 1] == nums[j]) {
                        j--;
                    }
                    i++;
                    j--;
                    //move left bound
                } else if (target - nums[i] > nums[j]) {
                    i++;
                    //move right bound
                } else {
                    j--;
                }
            }
        } else {
            for (int i = index; i < len - k + 1; i++) {
                //use current number to reduce ksum into k-1sum
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                if (temp != null) {
                    //add previous results
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }
}