package link;

import static link.LinkSomeMethod.getLen;

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
        LinkNode h = rl.reverseFromNToM(l1, 1, 3);

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
        //注意，此处一定先把headnext设为空
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
        if (l == null || l.next == null) {
            return head;
        }
        LinkNode pre = l.next;
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

    /**
     * 两个一组翻转链表
     */
    public LinkNode reverseKGroup2(LinkNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        LinkNode jHead = new LinkNode(0), jTail = jHead, oHead = new LinkNode(0), oTail = oHead, cur = head, temp = null;
        int i = 1;
        while (cur != null) {
            temp = cur.next;
            cur.next = null;
            if (i % 2 == 0) {
                oTail.next = cur;
                oTail = oTail.next;
            } else {
                jTail.next = cur;
                jTail = jTail.next;
            }
            cur = temp;
            i++;
        }
        LinkNode newHead = new LinkNode(0);
        cur = newHead;
        jTail = jHead.next;
        oTail = oHead.next;
        while (jTail != null && oTail != null) {
            cur.next = oTail;
            oTail = oTail.next;
            cur = cur.next;
            cur.next = jTail;
            jTail = jTail.next;
            cur = cur.next;
        }
        if (jTail != null) {
            cur.next = jTail;
        }
        if (oTail != null) {
            cur.next = oTail;
        }
        return newHead.next;

    }

    /**
     * k个一组翻转链表
     * leet：25
     */
    public LinkNode reverseKGroup(LinkNode head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
        int temp = k;
        LinkNode cur = head;
        while (cur != null && temp > 0) {
            cur = cur.next;
            temp--;
        }
        if (temp > 0) {
            return head;
        }
        LinkNode newHead = reverse(head, cur);
        head.next = reverseKGroup(cur, k);
        return newHead;
    }

    private LinkNode reverse(LinkNode head, LinkNode tail) {
        LinkNode pre = head, cur = head.next, temp = null;
        pre.next = null;
        while (cur != tail) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 链表右移k位
     * leet：61
     *
     * @param head
     * @param k
     * @return
     */
    public LinkNode rotateRight(LinkNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = getLen(head, null);
        k = k % len;
        //注意为0时的情况
        if (k == 0) {
            return head;
        }

        LinkNode fast = head, slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        LinkNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
