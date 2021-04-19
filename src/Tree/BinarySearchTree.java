package Tree;

/**
 * ����������Ĳ��Ҳ���ɾ������
 *
 * @author zc
 */
public class BinarySearchTree {
    TreeNode root;

    //���캯��
    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(TreeNode root) {
        this.root = root;
    }

    //����ֵΪvalue�Ľڵ�
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

    //����ֵΪvalue�Ľڵ㣬ÿ�εݹ鶼������nodeΪ���������룬���ز����������ĸ�
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

    //ɾ��ֵΪvalue�Ľڵ�   ÿ�εݹ鶼����ɾ����nodeΪ�������Ľڵ㣬���������ĸ�
    public TreeNode delete(int value) {
        return delete(root, value);
    }

    public TreeNode delete(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (node.val == value) {
            if (node.right != null) {
                //�ҵ�����������С�ڵ�
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

    //ɾ����nodeΪ�������е���С�ڵ㣬���ҷ����¸�
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

    //�������߶�(�ݹ�),�ǵݹ���Բ��ú��������ջ�����size��Ϊ�������߶�
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
