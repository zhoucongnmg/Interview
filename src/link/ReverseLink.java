package link;

import static link.LinkSomeMethod.getLen;

/**
 * ��ת����
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
     * ��ͷ��β��ת�����ǵݹ�ʵ��
     */
    public LinkNode reverse(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode pre = head, cur = head.next, temp = null;
        //ע�⣬�˴�һ���Ȱ�headnext��Ϊ��
        pre.next = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        //ע��˴�����pre
        return pre;
    }

    /**
     * ��ͷ��β��ת�����ݹ�ʵ��
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
     * ����һ��������1�������Ϊ1���������б����n��m����Ĳ��ַ�ת ��β���
     */
    public LinkNode reverseFromNToM(LinkNode head, int n, int m) {
        if (head == null || head.next == null) {
            return head;
        }
        int k = m - n;
        if (k <= 0) {
            return head;
        }
        //��ֹ��n=1ʱ�����ж�
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
     * ����һ�鷭ת����
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
     * k��һ�鷭ת����
     * leet��25
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
     * ��������kλ
     * leet��61
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
        //ע��Ϊ0ʱ�����
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
