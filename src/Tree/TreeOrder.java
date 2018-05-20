package Tree;

import java.util.*;

/**
 * ����������
 *
 * @author zc
 */
public class TreeOrder {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        TreeOrder to = new TreeOrder();

        // System.out.println("�������Ϊ");
        // to.postOrder(t1);

        // System.out.println("�������Ϊ");
        // to.inOrder(t1);

        // System.out.println("�������Ϊ");
        // to.preOrder(t1);

        System.out.println("��α���Ϊ");
        to.levelOrder(t1);
        // to.levelOrder2(t1);
        System.out.println("��α������ż����");
        ArrayList<ArrayList<TreeNode>> arr = new ArrayList();
        to.levelOrder3(t1, arr, 0);
        arr.forEach(i -> {
            i.forEach(j -> System.out.print(j.val));
            System.out.println();
        });

    }

    /**
     * �������
     */
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode temp = null;
        while (!s.isEmpty()) {
            temp = s.pop();
            temp.popTimes++;
            if (temp.popTimes == 3) {
                System.out.print(temp.val + " ");
                continue;
            }
            s.push(temp);
            if (temp.popTimes == 1) {
                if (temp.left != null) {
                    s.push(temp.left);
                }
                continue;
            }
            if (temp.popTimes == 2) {
                if (temp.right != null) {
                    s.push(temp.right);
                }
                continue;
            }
        }
        System.out.println();
    }

    /**
     * ��������ݹ�
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = null;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            temp = s.pop();
            temp.popTimes++;
            if (temp.popTimes == 2) {
                System.out.print(temp.val + " ");
                if (temp.right != null) {
                    s.push(temp.right);
                }
                continue;
            }
            s.push(temp);
            if (temp.popTimes == 1) {
                if (temp.left != null) {
                    s.push(temp.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * �ȸ�����
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode temp = null;
        while (!s.isEmpty()) {
            temp = s.pop();
            System.out.print(temp.val + " ");
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }
        }
        System.out.println();
    }

    /**
     * ��α������ǵݹ�
     */
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            temp = q.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                q.offer(temp.left);
            }
            if (temp.right != null) {
                q.offer(temp.right);
            }
        }
        System.out.println();
    }

    // ��α����ݹ�
    // ���������
    public void levelOrder3(TreeNode root, ArrayList<ArrayList<TreeNode>> lists, int level) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> list;
        if (lists.size() == level) {
            list = new ArrayList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        levelOrder3(root.left, lists, level + 1);
        levelOrder3(root.right, lists, level + 1);
    }

    // ��α������ż���㣬�����淽��
    public void levelOrder2(TreeNode root) {
        if (root == null) {
            return;
        }
        int level = 0;
        List<TreeNode> cur = new ArrayList<>();
        List<TreeNode> parent = null;
        cur.add(root);
        while (cur.size() > 0) {
            level++;
            if (level % 2 == 0) {
                for (TreeNode node : cur) {
                    System.out.print(node.val + " ");
                }
            }

            parent = cur;
            cur = new ArrayList<>();
            for (TreeNode node : parent) {
                if (node.left != null) {
                    cur.add(node.left);
                }
                if (node.right != null) {
                    cur.add(node.right);
                }
            }
            System.out.println();
        }
    }
}
