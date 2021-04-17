package link;

/**
 * @author zhoucong
 * @time 2018/6/23
 * 一个有序单链表，头尾衔接成环，在不改变大小顺序的情况下一个新数字
 */
public class LinkNodeInsert {
    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(2);
        LinkNode l2 = new LinkNode(4);
        l1.next = l2;
        l2.next = l1;
        LinkNode n = insert(l1, 3);
        LinkNode p = n;
        while (true) {
            System.out.println(p.val);
            p = p.next;
            if (p == n) {
                break;
            }
        }
    }

    public static LinkNode insert(LinkNode head, int a) {
        if (head == null) {
            LinkNode newHead = new LinkNode(a);
            newHead.next = newHead; //注意，首位成环
            return newHead;
        }
        if (a <= head.val) {
            LinkNode tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            LinkNode newHead = new LinkNode(a);
            newHead.next = head;
            tail.next = newHead;
            return newHead;
        }
        LinkNode pre = head, cur = head.next;
        while (cur != head && a > cur.val) {
            pre = pre.next;
            cur = cur.next;
        }
        LinkNode n = new LinkNode(a);
        n.next = cur;
        pre.next = n;
        return head;
    }
}
