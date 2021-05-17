package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * �������Ӹ��ڵ㵽Ҷ�ڵ�·��������֮��Ϊһ�ض���
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
        //�·������
        TreeNode t7 = new TreeNode(10);
        TreeNode t8 = new TreeNode(-10);
        TreeNode t9 = new TreeNode(-7);
        t7.left = t8;
        t7.right = t9;
        System.out.println("�·��ֵ��" + tp.getMaxSum(t7));
        //�·��
        tp.getMaxSumPath(t7, 0, new ArrayList<>());
        System.out.println("�·����");
        tp.maxPath.forEach(i -> System.out.println(i.val));
        System.out.println("�·��ֵ��" + tp.maxSum);

        List<TreeNode> path = tp.getPathSumIsK(t1, 19);
        if (path == null) {
            System.out.println("û���ҵ����·��");
            return;
        }
        for (TreeNode t : path) {
            System.out.print(t.val + " ");
        }
    }

    private List<List<Integer>> result = new ArrayList<>();

    /**
     * �������Ӹ��ڵ㵽Ҷ�ڵ�·��������֮��Ϊһ�ض���
     * ע��
     * ��ָ Offer 34
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
        //�˴�ע�⣬������·����һ��Ҫ�ѳ��ڷ���cur.add��ǰ�棬����ᵼ���Ѿ�������޷�ɾ��
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
     * �������Ӹ��ڵ㵽Ҷ�ڵ�·��������֮��Ϊһ�ض���,�ҵ�һ��·�����˳�
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

    //�·��ֵ����Ҷ�ڵ㵽���ڵ㣬ע��
    public int getMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxSum(root.left), getMaxSum(root.right)) + root.val;
    }


    /**
     * �·�� ע��
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
