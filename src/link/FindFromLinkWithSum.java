package link;

/**
 * �ҳ����������ĳһ��Ԫ�أ�ʹ����ЩԪ�صĺ� ����ĳ��������ֵ��������һ��Ԫ�ز�һ�����ڡ�
 *
 * @author zc
 */
public class FindFromLinkWithSum {


    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        LinkNode l5 = new LinkNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        FindFromLinkWithSum f1 = new FindFromLinkWithSum();
        f1.find(l1, 5);
        f1.find(l1, 11);
    }

    public void find(LinkNode head, int sum) {
        if (head == null)
            return;
        LinkNode start = head, temp = start;
        int count = 0;
        while (start != null) {
            while (temp != null) {
                count += temp.val;
                if (count == sum) {
                    System.out.println("��ʼ��Ϊ " + start.val + " ��ֹ��Ϊ " + temp.val);
                    return;
                }
                temp = temp.next;
            }
            start = start.next;
            temp = start;
            count = 0;
        }
        System.out.println("û���ҵ�������");
    }
}
