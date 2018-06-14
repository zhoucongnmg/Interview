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
        l4.next = l3;

        System.out.println("第一个公共节点值为：" + ls.findParent(l1, l4).val);
        System.out.println("倒数第4个节点的值为：" + ls.findLaskKNode(l1, 4));
        System.out.println("倒数第3个节点的值为：" + ls.findLaskKNode(l1, 3).val);
        System.out.println("原链表为：");
        ls.printLink(l1);
        LinkNode newHead = ls.sortList(l1);
        System.out.println("排序后为：");
        ls.printLink(newHead);

        LinkNode l10 = new LinkNode(1);
        LinkNode l11 = new LinkNode(3);
        LinkNode l12 = new LinkNode(5);
        LinkNode l13 = new LinkNode(2);
        LinkNode l14 = new LinkNode(4);
        l10.next = l11;
        l11.next = l12;
        l13.next = l14;
        System.out.println("合并两个有序链表的结果为");
        ls.printLink(ls.mergeTwoLink(l10, l13));
        System.out.println("删除节点后");
        ls.printLink(ls.deleteNode(l10, 3));
    }

    /**
     * 判断链表是否有环,有环则返回快慢指针相交点
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
    public LinkNode findParent(LinkNode head1, LinkNode head2, LinkNode node) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = getLen(head1, node);
        int len2 = getLen(head2, node);
        int k = Math.abs(len1 - len2);
        //此处注意变量名
        LinkNode longLink = len1 > len2 ? head1 : head2;
        LinkNode shortLink = len1 > len2 ? head2 : head1;
        while (k > 0) {
            longLink = longLink.next;
            k--;
        }
        //此处注意
        while (longLink != node) {
            if (longLink == shortLink) {
                return longLink;
            }
            longLink = longLink.next;
            shortLink = shortLink.next;
        }
        //此处注意 不返回null
        return node;
    }

    /**
     * 获取链表长度
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
     * 找链表倒数第k个节点
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
     * 合并两个有序链表，非递归实现
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
     * 单链表排序，要求时间复杂度OnLogn，空间复杂度O1，注意，多次没写上
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
     * 删除链表中的节点
     * 注意：1->2->6->3->4->5->6
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

    // 打印链表
    public void printLink(LinkNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
