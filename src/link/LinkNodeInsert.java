package link;

/**
 * @author zhoucong
 * @time 2018/6/23
 * һ����������ͷβ�νӳɻ����ڲ��ı��С˳��������һ��������
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
            newHead.next = newHead; //ע�⣬��λ�ɻ�
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
