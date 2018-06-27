package link;

/**
 * @author zhoucong
 * @time 2018/6/23
 * 一个有序单链表，头尾衔接成环，在不改变大小顺序的情况下插入一个新数字
 */
public class LinkNodeInsert {
    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(3);
        l1.next = l2;
        l2.next = l1;
        LinkNode n = insert(l1,0);
        LinkNode p = n;
        while(p.next !=n){
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static LinkNode insert(LinkNode head, int a) {
        if (head == null) {
            LinkNode newHead = new LinkNode(a);
            newHead.next = newHead;
            return newHead;
        }
        LinkNode tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        LinkNode newHead = new LinkNode(0);
        newHead.next = head;
        tail.next = newHead;
        LinkNode pre = newHead, cur = head;
        while (true) {
            if(cur == newHead || cur.val >= a){
                LinkNode i = new LinkNode(a);
                i.next = cur;
                pre.next = i;
                break;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
