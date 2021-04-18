package Tree;

/**
 * @author zhoucong
 * @version 1.0
 * @date 2021/3/23
 */
public class BalanceTree {
    private boolean balance = true;

    /**
     * 是否平衡二叉树
     * leet：55
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        height(root);
        return balance;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            balance = false;
        }
        return Math.max(left, right) + 1;
    }


    /**
     * leetcode:543 二叉树的直径
     */
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height2(root);
        return max;
    }

    public int height2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height2(root.left);
        int right = height2(root.right);
        if (left + right > max) {
            max = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
