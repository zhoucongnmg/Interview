package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ��һ���������У��ҳ������ӽڵ�ĵ�һ���������ڵ�
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
        System.out.println("�·�����");
        System.out.println(fp.findParent3(t1, t5, t4).node.val);
        System.out.println(fp.findParent3(t1, t3, t4).node.val);
    }

    /**
     * ���������
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
     * ���Ƕ���������������и��ڵ��ָ��,ת��Ϊ������������ڵ�
     */

    /**
     * �޸��ڵ�ָ��������Ȿ�������ҳ����������еĵ�һ����ͬԪ�ء� ���ȣ������ı����ҳ������������ӽڵ������·��������·����ʵ��������
     * Ȼ���ҳ���һ����ͬ��Ԫ�ؼ��ɡ����Ԫ��ǰ���Ԫ�ؾ�����ͬ��Ԫ�أ�Ҳ���ǵ�һ���������ڵ㡣
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
        // �ڵ㲻����
        if (!findPath(root, node1, list1)){
            return node2;
        }
        if(!findPath(root, node2, list2)) {
            return node1;
        }
        // �˴�ע��
        int len = Math.min(list1.size(), list2.size());
        for (int i = 0; i < len; i++) {
            if (list1.get(i) != list2.get(i)) {
                return list1.get(i - 1);
            }
        }
        // ע��˴�����ʾ����һ���ڵ�����һ���ڵ�ĸ��ڵ�
        return list1.get(len - 1);
    }

    // �ҵ���root��node��·��������list
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


    // �޸��ڵ�ָ��
    // ţ�Ʒ��� ���Խ��170
    // ����ҵ��������ڵ㣬�򷵻أ����򣨴�ʱ�����ڵ���ڵ�ǰroot�����ߣ�����node1��node2��Ϊ���ж�node1��node2Ϊ�գ�
    // ����ͨ������1�ξͿ����ж�node1��node2�Ƿ�Ϊ�գ��ҷ��ع������ڵ㣨����У�
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
            // �нڵ㲻����
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
