package Tree;

//子树、子结构问题
// 注意
public class IsSubTree {
    //子结构（可以是树中的一部分呢，不一定非要到达叶节点）
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val && isSame(root1, root2)) {
            return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        //区别点
        if (root1 == null) {
            return false;
        }
        return root1.val == root2.val && isSame(root1.left, root2.left) &&
                isSame(root1.right, root2.right);
    }

    //子树，必须到达叶节点
    public boolean HasSubtree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val && isSame2(root1, root2)) {
            return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    private boolean isSame2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        //区别点在这
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isSame2(root1.left, root2.left) &&
                isSame2(root1.right, root2.right);
    }
}