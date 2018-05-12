package link;

/**
 * 找出这个链表中某一段元素，使得这些元素的和 等于某个给定的值，这样的一段元素不一定存在。
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
                    System.out.println("起始点为 " + start.val + " 终止点为 " + temp.val);
                    return;
                }
                temp = temp.next;
            }
            start = start.next;
            temp = start;
            count = 0;
        }
        System.out.println("没有找到该区间");
    }
}
