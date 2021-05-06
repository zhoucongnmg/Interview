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
        l3.next = l4;

        System.out.println("��һ�������ڵ�ֵΪ��" + ls.findParent(l1, l4).val);
        System.out.println("������4���ڵ��ֵΪ��" + ls.findLaskKNode(l1, 4));
        System.out.println("������3���ڵ��ֵΪ��" + ls.findLaskKNode(l1, 3).val);
        System.out.println("ԭ����Ϊ��");
        ls.printLink(l1);
//        LinkNode newHead = ls.mergeSort(l1);
//        LinkNode newHead = ls.quickSort(l1);
        LinkNode newHead = ls.insertionSortList(l1);
        System.out.println("�����Ϊ��");
        ls.printLink(newHead);

        LinkNode l10 = new LinkNode(1);
        LinkNode l11 = new LinkNode(1);
        LinkNode l12 = new LinkNode(5);
        LinkNode l13 = new LinkNode(2);
        LinkNode l14 = new LinkNode(4);
        l10.next = l11;
        l11.next = l12;
        l13.next = l14;
        System.out.println("�ϲ�������������Ľ��Ϊ");
        ls.printLink(ls.mergeTwoLink(l10, l13));
    }

    /**
     * �ж������Ƿ��л�,�л��򷵻ؿ���ָ���ཻ��,leet:141
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
     * leet��142
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
        while (node1 != node2) {
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
    public LinkNode findParent(LinkNode head1, LinkNode head2, LinkNode end) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = getLen(head1, end);
        int len2 = getLen(head2, end);
        int k = Math.abs(len1 - len2);
        //�˴�ע�������
        LinkNode longLink = len1 > len2 ? head1 : head2;
        LinkNode shortLink = len1 > len2 ? head2 : head1;
        while (k > 0) {
            longLink = longLink.next;
            k--;
        }
        //�˴�ע��
        while (longLink != end) {
            if (longLink == shortLink) {
                return longLink;
            }
            longLink = longLink.next;
            shortLink = shortLink.next;
        }
        //�˴�ע�� ������null
        return end;
    }

    /**
     * ��ȡ������
     */
    public static int getLen(LinkNode head, LinkNode end) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        while (head != end) {
            head = head.next;
            len++;
        }
        return len;
    }

    /**
     * ����������k���ڵ�
     * ��ָ Offer 22
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
     * ɾ������ĵ�����kλ
     * leet��19
     */
    public LinkNode removeNthFromEnd(LinkNode head, int k) {
        if (head == null) {
            return null;
        }
        LinkNode newHead = new LinkNode(0), fast = newHead, slow = newHead;
        newHead.next = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }


    /**
     * �ϲ��������������ǵݹ�ʵ��
     * leet:21
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
     * �ϲ�k����������
     * leet��23
     *
     * @param lists
     * @return
     */
    public LinkNode mergeKLists(LinkNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private LinkNode mergeKLists(LinkNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        LinkNode h1 = lists[start];
        LinkNode h2 = mergeKLists(lists, start + 1, end);
        return mergeTwoLink(h1, h2);
    }

    /**
     * ����������Ҫ��ʱ�临�Ӷ�OnLogn���ռ临�Ӷ�O1��ע�⣬���ûд��
     * ������ǵ�����鲢����
     *
     * @param head
     */
    public LinkNode mergeSort(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        LinkNode temp = slow.next;
        slow.next = null;

        LinkNode l1 = mergeSort(head);
        LinkNode l2 = mergeSort(temp);

        return mergeTwoLink(l1, l2);
    }

    /**
     * ���������
     */
    public LinkNode quickSort(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode pivot = head;
        LinkNode leftHead = new LinkNode(0);
        LinkNode leftTail = leftHead;
        LinkNode rightHead = new LinkNode(0);
        LinkNode rightTail = rightHead;
        LinkNode cur = head.next;
        while (cur != null) {
            if (cur.val <= pivot.val) {
                leftTail.next = cur;
                leftTail = leftTail.next;
            } else {
                rightTail.next = cur;
                rightTail = rightTail.next;
            }
            cur = cur.next;
        }
        //�˴���Ҫע�⣬Ҫ������Ͽ��ڵݹ�
        leftTail.next = null;
        rightTail.next = null;
        LinkNode left = quickSort(leftHead.next);
        LinkNode right = quickSort(rightHead.next);
        LinkNode leftLast = findLast(left);
        pivot.next = right;
        if (leftLast == null) {
            return pivot;
        }
        leftLast.next = pivot;
        return left;
    }

    /**
     * �������������
     */
    public LinkNode insertionSortList(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode tempH = new LinkNode(0);
        tempH.next = head;
        LinkNode end = head, cur = head.next, temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = null;
            end = insert(tempH, end, cur);
            cur = temp;
        }
        return tempH.next;
    }

    private LinkNode insert(LinkNode start, LinkNode end, LinkNode k) {
        LinkNode pre = start, cur = start.next;
        if (k.val > end.val) {
            end.next = k;
            return k;
        }
        while (cur != end && cur.val < k.val) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = k;
        k.next = cur;
        end.next = null;
        return end;
    }

    /**
     * �ҵ��������һ���ڵ�
     *
     * @param head
     * @return
     */
    private LinkNode findLast(LinkNode head) {
        if (head == null) {
            return null;
        }
        LinkNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    // ��ӡ����
    public void printLink(LinkNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * ��ż����
     * �����ǿռ临�Ӷ�o��1�����򵥵��������ڿ���������������������һ��
     * leet��328
     */
    public LinkNode oddEvenList(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode jTail = head, cur = head.next, temp = null, oTail = head.next;
        int i = 2;
        while (cur != null) {
            if (i % 2 != 0) {
                temp = cur.next;
                cur.next = jTail.next;
                jTail.next = cur;
                jTail = jTail.next;
                oTail.next = temp;
                oTail = oTail.next;
                cur = temp;
            } else {
                cur = cur.next;
            }
            i++;
        }
        return head;
    }

    /**
     * ��ż����
     * �򵥵��������ڿ���������������������һ��
     * leet��328
     */
    public LinkNode oddEvenList2(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode j = new LinkNode(0), jTail = j, o = new LinkNode(0), oTail = o, cur = head, temp = null;
        int i = 1;
        while (cur != null) {
            //����ԭ����������ʱ����Ҫע���ԭ���ڵ��next�ÿ�
            if (i % 2 == 0) {
                oTail.next = cur;
                oTail = oTail.next;
            } else {
                jTail.next = cur;
                jTail = jTail.next;
            }
            cur = cur.next;
            i++;
        }
        //һ�����ֳ�������Ҫ����Ҫ�ڰ���������ĩβ�Ͽ�
        oTail.next = null;
        jTail.next = o.next;
        return j.next;
    }

}
