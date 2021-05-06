package link;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintDoubleLinked {

    public static void main(String[] args) {
        DoubleLinkedNode n1 = new DoubleLinkedNode(5);
        DoubleLinkedNode n2 = new DoubleLinkedNode(6);
        DoubleLinkedNode n3 = new DoubleLinkedNode(3);
        DoubleLinkedNode n4 = new DoubleLinkedNode(2);
        DoubleLinkedNode n5 = new DoubleLinkedNode(10);
        n1.next = n2;
        n2.pre = n1;
        n2.next = n3;
        n3.pre = n2;
        n3.next = n4;
        n4.pre = n3;
        n4.next = n5;
        n5.pre = n4;
        PrintDoubleLinked p = new PrintDoubleLinked();
        p.sortDoubleLink(n1);

    }

    public void sortDoubleLink(DoubleLinkedNode head) {
        DoubleLinkedNode root = convertTree(head);
        inOrder(root);
    }

    /**
     * 双向链表转化为二叉树
     * 给定任意双向链表，按从小到大顺序输出。要求时间复杂度O(nlogn)，空间复杂度O(1)
     * 多次不会
     *
     * @param head
     * @return
     */
    public DoubleLinkedNode convertTree(DoubleLinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoubleLinkedNode root = null, temp = null, cur = head;
        while (cur != null) {
            temp = cur.next;
            cur.pre = null;
            cur.next = null;
            root = insertNode(root, cur);
            cur = temp;
        }
        return root;
    }

    public DoubleLinkedNode insertNode(DoubleLinkedNode root, DoubleLinkedNode node) {
        if (root == null) {
            return node;
        }
        if (node == null) {
            return root;
        }
        if (root.val > node.val) {
            root.pre = insertNode(root.pre, node);
        } else {
            root.next = insertNode(root.next, node);
        }
        return root;
    }

    // 中序遍历
    public void inOrder(DoubleLinkedNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.pre);
        System.out.print(root.val + " ");
        inOrder(root.next);
    }

    /**
     * 有序链表转平衡二叉搜索树
     * leet:109
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(LinkNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> linkNodeList = new ArrayList<>();
        LinkNode cur = head;
        while (cur != null) {
            linkNodeList.add(cur.val);
            cur = cur.next;
        }
        return sortedListToBST(linkNodeList, 0, linkNodeList.size() - 1);
    }

    private TreeNode sortedListToBST(List<Integer> linkNodeList, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(linkNodeList.get(start));
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(linkNodeList.get(mid));
        root.left = sortedListToBST(linkNodeList, start, mid - 1);
        root.right = sortedListToBST(linkNodeList, mid + 1, end);
        return root;
    }
}
