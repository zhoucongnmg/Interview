package link;

/**
 * 删除排序链表中的重复节点
 * 判断节点q.next为空前先判断q是否为空
 */
public class DeleteDupInLinkList {

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
                p.next = q.next;  //此处是注意点
                q = q.next;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        return h.next;
    }
}