package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node4.left = node5;
        node5.right = node6;
        BinarySearchTree bt = new BinarySearchTree(node1);

        System.out.println("二叉树高度为：" + bt.getHeight());

        TreeNode root = bt.delete(2);
        printTree(root);
        System.out.println();
        TreeNode root1 = bt.insert(2);
        printTree(root1);
    }

    /**
     * 层次遍历
     *
     * @param root
     */
    private static void printTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            ;
            System.out.print(cur.val);
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }

        }

    }
}
