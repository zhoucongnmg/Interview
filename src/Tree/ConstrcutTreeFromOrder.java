package Tree;

public class ConstrcutTreeFromOrder {

    public static void main(String[] args) {
        ConstrcutTreeFromOrder ct = new ConstrcutTreeFromOrder();
        TreeOrder tr = new TreeOrder();

        int[] inorder = {1, 2, 3, 4, 5, 10};
        int[] postorder = {1, 2, 4, 3, 10, 5};
        System.out.println(tr.levelOrder(ct.buildTree(inorder, postorder)).toString());
    }

    /**
     * 已知后序遍历和中序遍历，求二叉树，注意不一定是二叉查找树
     * leetcode106
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }

    public TreeNode buildTree(int[] in, int instart, int inend, int[] post, int postend) {
        if (instart > inend) {
            return null;
        }
        if (instart == inend) {
            return new TreeNode(in[instart]);
        }
        TreeNode node = new TreeNode(post[postend]);
        int i = find(in, instart, inend, node.val);
        if (i == -1) {
            return null;
        }
        //注意postEnd赋值
        node.left = buildTree(in, instart, i - 1, post, postend - (inend - i) - 1);
        node.right = buildTree(in, i + 1, inend, post, postend - 1);
        return node;
    }

    public int find(int[] a, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (a[i] == val) {
                return i;
            }
        }
        return -1;
    }
}