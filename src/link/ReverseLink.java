package link;

/**
 * 反转链表
 *
 * @author zc
 */

public class ReverseLink {

    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        LinkNode l5 = new LinkNode(5);
        LinkNode l6 = new LinkNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ReverseLink rl = new ReverseLink();
        LinkSomeMethod ls = new LinkSomeMethod();
        LinkNode h = rl.reverseFromNToM(l1, 31, 8);

        ls.printLink(h);


//		ls.printLink(rl.reverse(l1));
//		ls.printLink(rl.reverse2(l6));
    }

    /**
     * 从头到尾反转链表，非递归实现
     */
    public LinkNode reverse(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode pre = head, cur = head.next, temp = null;
        pre.next = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        //注意此处返回pre
        return pre;
    }

    /**
     * 从头到尾反转链表，递归实现
     */
    public LinkNode reverse2(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode l = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return l;
    }

    /**
     * 给了一个链表，第1个结点标号为1，把链表中标号在n到m区间的部分反转 多次不会
     */
    public LinkNode reverseFromNToM(LinkNode head, int n, int m) {
        if (head == null || head.next == null) {
            return head;
        }
        int k = m - n;
        if (k <= 0) {
            return head;
        }
        //防止当n=1时大量判断
        LinkNode h = new LinkNode(0);
        h.next = head;
        LinkNode l = h;
        while (l != null && n - 1 > 0) {
            l = l.next;
            n--;
        }
        if (n > 1 || l == null) {
            return head;
        }
        LinkNode pre = l.next;
        if (pre == null) {
            return head;
        }
        LinkNode cur = pre.next, temp = null;
        while (cur != null && k > 0) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            k--;
        }
        l.next.next = cur;
        l.next = pre;
        return h.next;
    }
}
