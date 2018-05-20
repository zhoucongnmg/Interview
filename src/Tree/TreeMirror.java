package Tree;

/**
 * 二叉树镜像相关
 *
 * @author zc
 */
public class TreeMirror {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        TreeMirror tm = new TreeMirror();
        TreeOrder to = new TreeOrder();
        tm.reverseTree(t1);
        to.levelOrder(t1);
    }

    /**
     * 判断二叉树是否是对称
     * leeteCode101  千万不能用中序遍历
     *
     * @param root
     * @return
     */

    public boolean isMirror(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    /**
     * 输入一个二叉树返回它的镜像
     */
    public TreeNode reverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = reverseTree(root.right);
        root.right = reverseTree(temp);
        return root;
    }
}
