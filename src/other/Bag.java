package other;

import java.util.ArrayList;
import java.util.List;

/**
 * 01背包问题
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/fen-ge-deng-he-zi-ji-guan-yu-bei-bao-wen-sr7v/
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/5/3
 */
public class Bag {

    public static void main(String[] args) {
        Bag bag = new Bag();
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(bag.canPartition(nums));
    }

    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * leet：416
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        //注意
        if (sum % 2 != 0) {
            return false;
        }
        List<Integer> cur = new ArrayList<>();
        return canPartition(nums, 0, nums.length - 1, sum / 2, cur);
    }

    private boolean canPartition(int[] nums, int start, int end, int sum, List<Integer> cur) {
        //注意
        if (sum == 0) {
            return true;
        }
        if (start > end || sum < 0) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            cur.add(nums[i]);
            if (canPartition(nums, i + 1, end, sum - nums[i], cur)) {
                return true;
            }
            cur.remove(cur.size() - 1);
        }
        return false;
    }
}
