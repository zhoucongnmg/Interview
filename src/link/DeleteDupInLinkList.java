package link;

/**
 * 删除排序链表中的重复节点
 * 判断节点q.next为空前先判断q是否为空
 */
public class DeleteDupInLinkList {

    public static void main(String[] args) {
        DeleteDupInLinkList remove = new DeleteDupInLinkList();
        LinkNode l10 = new LinkNode(1);
        LinkNode l11 = new LinkNode(1);
        LinkNode l12 = new LinkNode(5);
        LinkNode l13 = new LinkNode(2);
        LinkNode l14 = new LinkNode(4);
        LinkNode l15 = new LinkNode(1);
        l10.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        LinkNode node = remove.deleteNode(l10, 1);
        System.out.println(node);
    }

    //leet 83
    //Given 1->1->2->3->3, return 1->2->3.
    public LinkNode deleteDuplicates(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    //leet 82
    //Given 1->1->1->2->3, return 2->3.
    //注意   1->1 的情况  应该返回空
    public LinkNode deleteDuplicates1(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode h = new LinkNode(0);
        h.next = head;
        LinkNode p = h, q = h.next;
        while (q != null && q.next != null) { //这种判断时要注意，q.next为null时是否需要真的跳出循环
            //找到重复的最后一个节点
            //此处要注意校验
            while (q.next != null && q.val == q.next.val) {
                q = q.next;
            }
            if (p.next != q) {
                p.next = q.next;  //此处是注意点,此时千万不要移动p，case：[1,2,3,3,4,4,5]
                q = q.next;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        return h.next;
    }

    /**
     * 删除链表中的节点
     * 注意：1->2->6->3->4->5->6
     *
     * @param head
     */

    public LinkNode deleteNode(LinkNode head, int val) {
        if (head == null) {
            return null;
        }
        LinkNode newHead = new LinkNode(0), pre = newHead;
        newHead.next = head;
        LinkNode cur = head;
        while (cur != null) {
            //此处注意，等于val的一直跳过
            while (cur != null && cur.val == val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = pre.next;
            if (cur != null) {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}