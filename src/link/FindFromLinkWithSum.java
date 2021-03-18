package link;

import java.util.ArrayList;
import java.util.List;

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
        LinkNode l6 = new LinkNode(-1);
        LinkNode l7 = new LinkNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        FindFromLinkWithSum f1 = new FindFromLinkWithSum();
        System.out.println(f1.find(l1, 5).toString());
        System.out.println(f1.find(l1, 11).toString());
//        f1.find(l1,5,new ArrayList<>());
//        f1.find(l1,11,new ArrayList<>());
    }

    public List<List<LinkNode>> find(LinkNode head, int sum) {
        if (head == null) {
            return null;
        }
        LinkNode start = head, temp = start;
        int count = 0;
        List<List<LinkNode>> result = new ArrayList<>();
        while (start != null) {
            while (temp != null) {
                count += temp.val;
                if (count == sum) {
                    List<LinkNode> resultItem = new ArrayList<>();
                    resultItem.add(start);
                    resultItem.add(temp);
                    result.add(resultItem);
                }
                temp = temp.next;
            }
            start = start.next;
            temp = start;
            count = 0;
        }
        return result;
    }

//    public void find(LinkNode head, int sum, List<LinkNode> path) {
//        if (head == null) {
//            return;
//        }
//        path.add(head);
//        if (sum == head.val) {
//            for (LinkNode linkNode : path) {
//                System.out.print(linkNode.val+" ");
//            }
//            System.out.println();
//            return;
//        }
//        find(head.next, sum - head.val, path);
//        path.remove(path.size() - 1);
////        find(head.next, sum, path);
//    }
}
