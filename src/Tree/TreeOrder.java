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

//        System.out.println("�������Ϊ");
//        System.out.println(to.postOrder(t1).toString());

//        System.out.println("�������Ϊ");
//        System.out.println(to.inOrder(t1).toString());

//        System.out.println("�������Ϊ");
//        System.out.println(to.preOrder(t1).toString());

        System.out.println("��α���Ϊ");
        to.levelOrder(t1);
        // to.levelOrder2(t1);
        System.out.println("��α������ż����");
        ArrayList<ArrayList<TreeNode>> arr = new ArrayList<>();
        arr.forEach(i -> {
            i.forEach(j -> System.out.print(j.val));
            System.out.println();
        });

    }

    /**
     * �������
     * leet:145
     */
    public List<TreeNode> postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode temp = null;
        while (!s.isEmpty()) {
            temp = s.peek();
            temp.popTimes++;
            if (temp.popTimes == 1) {
                if (temp.left != null) {
                    s.push(temp.left);
                }
            } else if (temp.popTimes == 2) {
                if (temp.right != null) {
                    s.push(temp.right);
                }
            } else {
                s.pop();
                result.add(temp);
            }
        }
        return result;
    }

    /**
     * ��������ݹ�
     * leet:94
     */
    public List<TreeNode> inOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> result = new ArrayList<>();
        TreeNode temp = null;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            temp = s.peek();
            temp.popTimes++;
            if (temp.popTimes == 2) {
                s.pop();
                result.add(temp);
                if (temp.right != null) {
                    s.push(temp.right);
                }
            } else if (temp.popTimes == 1) {
                if (temp.left != null) {
                    s.push(temp.left);
                }
            }
        }
        return result;
    }

    /**
     * �ȸ�����
     * leet:144
     */
    public List<TreeNode> preOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        List<TreeNode> result = new ArrayList<>();
        s.push(root);
        TreeNode temp = null;
        while (!s.isEmpty()) {
            temp = s.pop();
            result.add(temp);
            if (temp.right != null) {
                s.push(temp.right);
            }
            if (temp.left != null) {
                s.push(temp.left);
            }
        }
        return result;
    }

    /**
     * ��α������ǵݹ�
     * leet:102
     */
    public List<TreeNode> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> result = new ArrayList<>();
        TreeNode temp = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            temp = q.poll();
            result.add(temp);
            if (temp.left != null) {
                q.offer(temp.left);
            }
            if (temp.right != null) {
                q.offer(temp.right);
            }
        }
        return result;
    }

    /**
     * ��α���
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> pre = new ArrayList<>();
        pre.add(root);
        while (pre.size() != 0) {
            List<Integer> curResult = new ArrayList<>();
            List<TreeNode> cur = new ArrayList<>();
            for (TreeNode node : pre) {
                curResult.add(node.val);
                if (node.left != null) {
                    cur.add(node.left);
                }
                if (node.right != null) {
                    cur.add(node.right);
                }
            }
            result.add(curResult);
            pre = cur;
        }
        return result;
    }


    /**
     * ��ݲ�α���
     * leet��103
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> pre = new ArrayList<>();
        pre.add(root);
        int level = 0;
        while(pre.size() > 0) {
            level++;
            List<Integer> curResult = new ArrayList<>();
            List<TreeNode> cur = new ArrayList<>();
            if (level % 2 != 0) {
                for (int i=0; i<pre.size(); i++) {
                    curResult.add(pre.get(i).val);
                }
            } else {
                for (int i=pre.size()-1; i>=0; i--) {
                    curResult.add(pre.get(i).val);
                }
            }
            result.add(curResult);
            for (TreeNode node : pre) {
                if (node.left != null) {
                    cur.add(node.left);
                }
                if (node.right != null) {
                    cur.add(node.right);
                }
            }
            pre = cur;
        }
        return result;
    }
}
