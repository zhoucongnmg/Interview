package link;

public class LinkSomeMethod {
    public static void main(String[] args) {
        LinkSomeMethod ls = new LinkSomeMethod();

        LinkNode l5 = new LinkNode(5);
        LinkNode l6 = new LinkNode(6);
        LinkNode l7 = new LinkNode(7);
        LinkNode l8 = new LinkNode(8);
        LinkNode l9 = new LinkNode(9);
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l7;
        System.out.println("����ڣ�" + ls.findHuanIn(l5).val);

        LinkNode l1 = new LinkNode(3);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(1);
        LinkNode l4 = new LinkNode(4);

        l1.next = l2;
        l2.next = l3;
        l4.next = l3;

        System.out.println("��һ�������ڵ�ֵΪ��" + ls.findParent(l1, l4).val);
        System.out.println("������4���ڵ��ֵΪ��" + ls.findLaskKNode(l1, 4));
        System.out.println("������3���ڵ��ֵΪ��" + ls.findLaskKNode(l1, 3).val);
        System.out.println("ԭ����Ϊ��");
        ls.printLink(l1);
        LinkNode newHead = ls.sortList(l1);
        System.out.println("�����Ϊ��");
        ls.printLink(newHead);

        LinkNode l10 = new LinkNode(1);
        LinkNode l11 = new LinkNode(3);
        LinkNode l12 = new LinkNode(5);
        LinkNode l13 = new LinkNode(2);
        LinkNode l14 = new LinkNode(4);
        l10.next = l11;
        l11.next = l12;
        l13.next = l14;
        System.out.println("�ϲ�������������Ľ��Ϊ");
        ls.printLink(ls.mergeTwoLink(l10, l13));
        System.out.println("ɾ���ڵ��");
        ls.printLink(ls.deleteNode(l10, 3));
    }

    /**
     * �ж������Ƿ��л�,�л��򷵻ؿ���ָ���ཻ��
     */
    public LinkNode hasHuan(LinkNode head) {
        if (head == null) {
            return null;
        }
        LinkNode fast = head, slow = head;
        // �˴�Ӧע��Ҫ���ж�fast��Ϊnull�����ж�fast.next��Ϊnull
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    /**
     * �ҵ���������� ����һ�������������ڵ����set�У���һ���ظ��Ľڵ㼴Ϊ����� ������������
     */
    public LinkNode findHuanIn(LinkNode head) {
        if (head == null) {
            return null;
        }
        LinkNode k = hasHuan(head);
        if (k == null) {
            return null;
        }
        LinkNode node1 = head, node2 = k;
        while (true) {
            if (node1 == node2) {
                break;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    /**
     * �����������һ�������ڵ�
     */
    public LinkNode findParent(LinkNode head1, LinkNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // ��ȡ������ڵ�  �˴�ע��
        LinkNode node1 = findHuanIn(head1);
        LinkNode node2 = findHuanIn(head2);
        // �������޻�
        if (node1 == null && node2 == null) {
            return findParent(head1, head2, null);
        }// �������л�
        else if (node1 != null && node2 != null) {
            // �ж��Ƿ��ཻ��������Ƿ��������1����ڵ�
            if (isXiangJiao(head2, node1)) {
                // ���㲻�ڻ���
                if (node1 == node2) {
                    return findParent(head1, head2, node1);
                } else {
                    // �����ڻ��ϣ��������������������ڵ㼴��
                    return node1;
                }
            } else {
                return null;
            }
        } else {
            // һ���л�һ��û������û�н���
            return null;
        }
    }

    // �л������Ƿ��ཻ
    public boolean isXiangJiao(LinkNode head, LinkNode node) {
        while (head != null) {
            if (head == node) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // �����޻������һ�������ڵ�
    public LinkNode findParent(LinkNode head1, LinkNode head2, LinkNode node) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = getLen(head1, node);
        int len2 = getLen(head2, node);
        int k = Math.abs(len1 - len2);
        //�˴�ע�������
        LinkNode longLink = len1 > len2 ? head1 : head2;
        LinkNode shortLink = len1 > len2 ? head2 : head1;
        while (k > 0) {
            longLink = longLink.next;
            k--;
        }
        //�˴�ע��
        while (longLink != node) {
            if (longLink == shortLink) {
                return longLink;
            }
            longLink = longLink.next;
            shortLink = shortLink.next;
        }
        //�˴�ע�� ������null
        return node;
    }

    /**
     * ��ȡ������
     */
    public int getLen(LinkNode head, LinkNode node) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        while (head != node) {
            head = head.next;
            len++;
        }
        return len;
    }

    /**
     * ����������k���ڵ�
     */
    public LinkNode findLaskKNode(LinkNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        LinkNode fast = head, slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * �ϲ��������������ǵݹ�ʵ��
     */
    public LinkNode mergeTwoLink(LinkNode head1, LinkNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        LinkNode head = new LinkNode(0);
        LinkNode temp = head;
        while (head1 != null && head2 != null) {
            if (head1.val > head2.val) {
                temp.next = head2;
                head2 = head2.next;
            } else {
                temp.next = head1;
                head1 = head1.next;
            }
            temp = temp.next;
        }
        if (head1 == null) {
            temp.next = head2;
        } else {
            temp.next = head1;
        }
        return head.next;
    }

    /**
     * �ϲ��������������ݹ�ʵ��
     */
    public LinkNode mergeTwoLink1(LinkNode list1, LinkNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLink(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLink(list1, list2.next);
            return list2;
        }
    }

    /**
     * ����������Ҫ��ʱ�临�Ӷ�OnLogn���ռ临�Ӷ�O1��ע�⣬���ûд��
     *
     * @param head
     */
    public LinkNode sortList(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode fast = head, slow = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;

        LinkNode l1 = sortList(head);
        LinkNode l2 = sortList(slow);

        return mergeTwoLink(l1, l2);
    }

    /**
     * ɾ�������еĽڵ�
     * ע�⣺1->2->6->3->4->5->6
     *
     * @param head
     */

    public LinkNode deleteNode(LinkNode head, int val) {
        if (head == null) {
            return null;
        }
        LinkNode l = new LinkNode(0), pre = l;
        l.next = head;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                break;
            }
            pre = head;
            head = head.next;
        }
        return l.next;
    }

    // ��ӡ����
    public void printLink(LinkNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
