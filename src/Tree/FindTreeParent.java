package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个二叉树中，找出两个子节点的第一个公共父节点
 *
 * @author zc
 */
public class FindTreeParent {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(3);
        t1.left = t2;
        t2.left = t5;
        t2.right = t3;
        t3.right = t4;
        FindTreeParent fp = new FindTreeParent();
        System.out.println(fp.findParent(t1, t5, t4).val);
        System.out.println(fp.findParent2(t1, t5, t4).val);
        System.out.println(fp.findParent2(t1, t3, t4).val);
        System.out.println("新方法：");
        System.out.println(fp.findParent3(t1, t5, t4).node.val);
        System.out.println(fp.findParent3(t1, t3, t4).node.val);
    }

    /**
     * 二叉查找树
     */
    public TreeNode findParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return null;
        }
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val < root.val && node2.val < root.val) {
            return findParent(root.left, node1, node2);
        }
        if (node1.val > root.val && node2.val > root.val) {
            return findParent(root.right, node1, node2);
        }
        return root;
    }

    /**
     * 不是二叉查找树，但是有父节点的指针,转换为链表最近公共节点
     */

    /**
     * 无父节点指针这个问题本质上是找出两个链表中的第一个不同元素。 首先，用树的遍历找出含有这两个子节点的两条路径。两条路径其实两个链表。
     * 然后，找出第一个不同的元素即可。这个元素前面的元素就是相同的元素，也就是第一个公共父节点。
     */
    public TreeNode findParent2(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return null;
        }
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        // 节点不存在
        if (!findPath(root, node1, list1)){
            return node2;
        }
        if(!findPath(root, node2, list2)) {
            return node1;
        }
        // 此处注意
        int len = Math.min(list1.size(), list2.size());
        for (int i = 0; i < len; i++) {
            if (list1.get(i) != list2.get(i)) {
                return list1.get(i - 1);
            }
        }
        // 注意此处，表示其中一个节点是另一个节点的父节点
        return list1.get(len - 1);
    }

    // 找到从root到node的路径并放入list
    public boolean findPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root == node) {
            return true;
        }
        if (findPath(root.left, node, path)) {
            return true;
        }
        if (findPath(root.right, node, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }


    // 无父节点指针
    // 牛逼方法 面试金典170
    // 如果找到公共父节点，则返回，否则（此时两个节点必在当前root的两边）返回node1或node2（为了判断node1或node2为空）
    // 这样通过遍历1次就可以判断node1和node2是否为空，且返回公共父节点（如果有）
    public Result findParent3(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == node1 && root == node2) {
            return new Result(root, true);
        }
        Result left = findParent3(root.left, node1, node2);
        if (left.isGongTongZuxian) {
            return new Result(left.node, true);
        }
        Result right = findParent3(root.right, node1, node2);
        if (right.isGongTongZuxian) {
            return new Result(right.node, true);
        }
        if (root == node1 || root == node2) {
            boolean is = left.node != null || right.node != null;
            return new Result(root, is);
        }
        if (left.node == null || right.node == null) {
            // 有节点不存在
            return left.node == null ? new Result(right.node, false) : new Result(left.node, false);
        } else {
            return new Result(root, true);
        }
    }
}

class Result {
    TreeNode node;
    boolean isGongTongZuxian;

    public Result(TreeNode node, boolean isGongTongZuxian) {
        this.node = node;
        this.isGongTongZuxian = isGongTongZuxian;
    }
}
