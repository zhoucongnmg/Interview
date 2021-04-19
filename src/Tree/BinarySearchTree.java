package Tree;

/**
 * 二叉查找树的查找插入删除操作
 *
 * @author zc
 */
public class BinarySearchTree {
    TreeNode root;

    //构造函数
    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    //查找值为value的节点
    public TreeNode find(int value) {
        return find(root, value);
    }

    public TreeNode find(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (node.val == value) {
            return node;
        } else if (node.val > value) {
            return find(node.left, value);
        } else {
            return find(node.right, value);
        }
    }

    //插入值为value的节点，每次递归都是向以node为根的树插入，返回插入完新树的根
    public TreeNode insert(int value) {
        return insert(root, value);
    }

    public TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (node.val > value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        return node;
    }

    //删除值为value的节点   每次递归都是以删除以node为根的树的节点，返回新树的根
    public TreeNode delete(int value) {
        return delete(root, value);
    }

    public TreeNode delete(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (node.val == value) {
            if (node.right != null) {
                //找到右子树的最小节点
                node.val = findMin(node.right).val;
                node.right = deleteMin(node.right);
                return node;
            } else  {
                return  node.left;
            }
        }
        if (node.val > value) {
            node.left = delete(node.left, value);
        } else {
            node.right = delete(node.right, value);
        }
        return node;
    }

    public TreeNode findMin(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    //删除以node为根的树中的最小节点，并且返回新根
    public TreeNode deleteMin(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    //二叉树高度(递归),非递归可以采用后根遍历，栈的最大size即为二叉树高度
    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
