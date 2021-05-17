package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树从根节点到叶节点路径上数字之和为一特定数
 *
 * @author zc
 */
public class TreePathSum {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(12);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        TreePathSum tp = new TreePathSum();
        //最长路径长度
        TreeNode t7 = new TreeNode(10);
        TreeNode t8 = new TreeNode(-10);
        TreeNode t9 = new TreeNode(-7);
        t7.left = t8;
        t7.right = t9;
        System.out.println("最长路径值：" + tp.getMaxSum(t7));
        //最长路径
        tp.getMaxSumPath(t7, 0, new ArrayList<>());
        System.out.println("最长路径：");
        tp.maxPath.forEach(i -> System.out.println(i.val));
        System.out.println("最长路径值：" + tp.maxSum);

        List<TreeNode> path = tp.getPathSumIsK(t1, 19);
        if (path == null) {
            System.out.println("没有找到相关路径");
            return;
        }
        for (TreeNode t : path) {
            System.out.print(t.val + " ");
        }
    }

    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 二叉树从根节点到叶节点路径上数字之和为一特定数
     * 注意
     * 剑指 Offer 34
     *
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        List<Integer> cur = new ArrayList<>();
        pathSum(root, target, cur);
        return result;
    }

    private void pathSum(TreeNode root, int k, List<Integer> cur) {
        if (root == null) {
            return;
        }
        //此处注意，找所有路径，一定要把出口放在cur.add的前面，否则会导致已经加入的无法删除
        if (root.val == k && root.left == null && root.right == null) {
            List<Integer> curResult = new ArrayList<>(cur);
            curResult.add(root.val);
            result.add(curResult);
            return;
        }
        cur.add(root.val);
        pathSum(root.left, k - root.val, cur);
        pathSum(root.right, k - root.val, cur);
        cur.remove(cur.size() - 1);

    }

    /**
     * 二叉树从根节点到叶节点路径上数字之和为一特定数,找到一条路径就退出
     *
     * @param root
     * @param sum
     * @return
     */
    public List<TreeNode> getPathSumIsK(TreeNode root, int sum) {
        if (root == null) {
            return null;
        }
        List<TreeNode> path = new ArrayList<>();
        if (getPathSumIsK(root, sum, path)) {
            return path;
        } else {
            return null;
        }
    }

    public boolean getPathSumIsK(TreeNode root, int sum, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        if (getPathSumIsK(root.left, sum - root.val, path)) {
            return true;
        }
        if (getPathSumIsK(root.right, sum - root.val, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    //最长路径值，从叶节点到根节点，注意
    public int getMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxSum(root.left), getMaxSum(root.right)) + root.val;
    }


    /**
     * 最长路径 注意
     */
    int maxSum = Integer.MIN_VALUE;
    List<TreeNode> maxPath;

    public void getMaxSumPath(TreeNode root, int sum, List<TreeNode> path) {
        if (root == null) {
            if (sum > maxSum) {
                maxSum = sum;
                maxPath = new ArrayList<>(path);
            }
            return;
        }
        path.add(root);
        getMaxSumPath(root.left, sum + root.val, path);
        getMaxSumPath(root.right, sum + root.val, path);
        path.remove(path.size() - 1);
    }
}
