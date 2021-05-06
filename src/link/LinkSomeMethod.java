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
        System.out.println("环入口：" + ls.findHuanIn(l5).val);

        LinkNode l1 = new LinkNode(3);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(1);
        LinkNode l4 = new LinkNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        System.out.println("第一个公共节点值为：" + ls.findParent(l1, l4).val);
        System.out.println("倒数第4个节点的值为：" + ls.findLaskKNode(l1, 4));
        System.out.println("倒数第3个节点的值为：" + ls.findLaskKNode(l1, 3).val);
        System.out.println("原链表为：");
        ls.printLink(l1);
//        LinkNode newHead = ls.mergeSort(l1);
//        LinkNode newHead = ls.quickSort(l1);
        LinkNode newHead = ls.insertionSortList(l1);
        System.out.println("排序后为：");
        ls.printLink(newHead);

        LinkNode l10 = new LinkNode(1);
        LinkNode l11 = new LinkNode(1);
        LinkNode l12 = new LinkNode(5);
        LinkNode l13 = new LinkNode(2);
        LinkNode l14 = new LinkNode(4);
        l10.next = l11;
        l11.next = l12;
        l13.next = l14;
        System.out.println("合并两个有序链表的结果为");
        ls.printLink(ls.mergeTwoLink(l10, l13));
    }

    /**
     * 判断链表是否有环,有环则返回快慢指针相交点,leet:141
     */
    public LinkNode hasHuan(LinkNode head) {
        if (head == null) {
            return null;
        }
        LinkNode fast = head, slow = head;
        // 此处应注意要先判断fast不为null，再判断fast.next不为null
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
     * 找到链表环的起点 方法一、遍历链表，将节点放于set中，第一个重复的节点即为环起点 方法二、如下
     * leet：142
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
     * 求两个链表第一个公共节点
     */
    public LinkNode findParent(LinkNode head1, LinkNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 获取环的入口点  此处注意
        LinkNode node1 = findHuanIn(head1);
        LinkNode node2 = findHuanIn(head2);
        // 两个都无环
        if (node1 == null && node2 == null) {
            return findParent(head1, head2, null);
        }// 两个都有环
        else if (node1 != null && node2 != null) {
            // 判断是否相交，链表二是否包含链表1的入口点
            if (isXiangJiao(head2, node1)) {
                // 交点不在环上
                if (node1 == node2) {
                    return findParent(head1, head2, node1);
                } else {
                    // 交点在环上，返回两个链表的任意入口点即可
                    return node1;
                }
            } else {
                return null;
            }
        } else {
            // 一个有环一个没环，则没有交点
            return null;
        }
    }

    // 有环链表是否相交
    public boolean isXiangJiao(LinkNode head, LinkNode node) {
        while (head != null) {
            if (head == node) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    // 两个无环链表第一个公共节点
    public LinkNode findParent(LinkNode head1, LinkNode head2, LinkNode end) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = getLen(head1, end);
        int len2 = getLen(head2, end);
        int k = Math.abs(len1 - len2);
        //此处注意变量名
        LinkNode longLink = len1 > len2 ? head1 : head2;
        LinkNode shortLink = len1 > len2 ? head2 : head1;
        while (k > 0) {
            longLink = longLink.next;
            k--;
        }
        //此处注意
        while (longLink != end) {
            if (longLink == shortLink) {
                return longLink;
            }
            longLink = longLink.next;
            shortLink = shortLink.next;
        }
        //此处注意 不返回null
        return end;
    }

    /**
     * 获取链表长度
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
     * 找链表倒数第k个节点
     * 剑指 Offer 22
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
     * 删除链表的倒数第k位
     * leet：19
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
     * 合并两个有序链表，非递归实现
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
     * 合并两个有序链表，递归实现
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
     * 合并k个有序链表
     * leet：23
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
     * 单链表排序，要求时间复杂度OnLogn，空间复杂度O1，注意，多次没写上
     * 这个就是单链表归并排序
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
     * 单链表快排
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
        //此处需要注意，要把链表断开在递归
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
     * 单链表插入排序
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
     * 找到链表最后一个节点
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

    // 打印链表
    public void printLink(LinkNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 奇偶链表
     * 下面是空间复杂度o（1），简单的做法是在开两条链，把两条链组在一起
     * leet：328
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
     * 奇偶链表
     * 简单的做法是在开两条链，把两条链组在一起
     * leet：328
     */
    public LinkNode oddEvenList2(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode j = new LinkNode(0), jTail = j, o = new LinkNode(0), oTail = o, cur = head, temp = null;
        int i = 1;
        while (cur != null) {
            //依据原链表开新链的时候，需要注意把原来节点的next置空
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
        //一条链分成两条需要，需要在把两条链的末尾断开
        oTail.next = null;
        jTail.next = o.next;
        return j.next;
    }

}
