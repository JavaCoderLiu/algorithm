package class34;

import java.util.List;

public class Code06_SortList {

    public static ListNode start;

    public static ListNode end;

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = getLinkLength(head);
        ListNode l1, r1, l2, r2, next, lastTeamEnd;
        for (int step = 1; step < length; step = step << 1) {
            l1 = head;
            r1 = findEnd(l1, step);
            l2 = r1.next;
            r2 = findEnd(l2, step);
            next = r2.next;
            r1.next = null;
            r2.next = null;
            merge(l1, r1, l2, r2);
            head = start;
            lastTeamEnd = end;
            while (next != null) {
                l1 = next;
                r1 = findEnd(l1, step);
                if (r1.next == null) {
                    lastTeamEnd.next = l1;
                    break;
                }
                l2 = r1.next;
                r2 = findEnd(l2, step);
                next = r2.next;
                r1.next = null;
                r2.next = null;
                merge(l1, r1, l2, r2);
                lastTeamEnd.next = start;
                lastTeamEnd = end;
            }
        }
        return head;
    }

    public void merge(ListNode l1, ListNode r1, ListNode l2, ListNode r2) {
        if (l1.val <= l2.val) {
            start = l1;
            end = l1;
            l1 = l1.next;
        } else {
            start = l2;
            end = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                end.next = l1;
                end = l1;
                l1 = l1.next;
            } else {
                end.next = l2;
                end = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            end.next = l2;
            end = r2;
        }
        if (l2 == null) {
            end.next = l1;
            end = r1;
        }
    }

    // 包括s在内，往下数k个节点返回
    // 如果不够，返回最后一个数到的非空节点
    public ListNode findEnd(ListNode s, int k) {
        while (k != 1 && s.next != null) {
            k--;
            s = s.next;
        }
        return s;
    }

    // 获取链表长度
    public int getLinkLength(ListNode head) {
        int sum = 1;
        while (head.next != null) {
            sum++;
            head = head.next;
        }
        return sum;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
    }
}
