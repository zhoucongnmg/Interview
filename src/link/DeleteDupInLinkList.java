package link;
//ɾ�����������е��ظ��ڵ�
public class DeleteDupInLinkList{

	//Given 1->1->2->3->3, return 1->2->3.
	public LinkNode deleteDuplicates(LinkNode head) {
        if(head == null || head.next == null)
            return head;
        LinkNode p = head;
        while(p.next != null){
            if(p.val == p.next.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return head;
    }
    //Given 1->1->1->2->3, return 2->3.
     public LinkNode deleteDuplicates1(LinkNode head) {
        if(head == null || head.next == null)
            return head;
        LinkNode h = new LinkNode (0);
        h.next = head;
        LinkNode p = h, q = h.next;
        while(q != null && q.next != null){
            //�ҵ��ظ������һ���ڵ�
            //�˴�Ҫע��У��
            while(q.next != null && q.val == q.next.val)
                q = q.next;
            if(p.next != q){
                p.next = q.next;
                q = q.next;
            }
            else{
                p = p.next;
                q = q.next;
            }
        }
        return h.next;
    }
}