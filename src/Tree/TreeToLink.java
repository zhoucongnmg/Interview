package Tree;

/**
 * 二叉树转双向链表
 * 剑指 Offer 36
 *
 * @author zhoucong
 * @version 1.0
 * @date 2021/4/30
 */
public class TreeToLink {
    public static void main(String[] args) {
        TreeToLink treeToLink = new TreeToLink();
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        TreeNode head = treeToLink.treeToDoublyList(t1);
        System.out.println(head);
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode newHead = null;
        if (root.left != null) {
            newHead = treeToDoublyList(root.left);
            TreeNode leftT = getTail(newHead);
            leftT.right = root;
            root.left = leftT;
        }
        if (root.right != null) {
            TreeNode rightH = treeToDoublyList(root.right);
            root.right = rightH;
            rightH.left = root;
        }
        return newHead == null ? root : newHead;
    }

    private TreeNode getTail(TreeNode head) {
        while (head != null && head.right != null) {
            head = head.right;
        }
        return head;
    }
}
