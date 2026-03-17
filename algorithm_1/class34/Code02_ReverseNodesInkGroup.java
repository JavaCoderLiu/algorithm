package class34;

// 每k个节点一组翻转链表
public class Code02_ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = getNodeLength(head);
        if (k <= 1 || length < k) {
            return head;
        }
        ListNode groupEndNode = getGroupLastNode(head, k);
        reverse(head, groupEndNode);
        ListNode lastGroupEndNode = head;
        head = groupEndNode;
        ListNode groupStartNode = null;
        while (lastGroupEndNode.next != null) {
            groupStartNode = lastGroupEndNode.next;
            groupEndNode = getGroupLastNode(groupStartNode, k);
            if (groupEndNode == null) {
                return head;
            }
            reverse(groupStartNode, groupEndNode);
            lastGroupEndNode.next = groupEndNode;
            lastGroupEndNode = groupStartNode;
        }
        return head;
    }

    // 链表局部反转
    private void reverse(ListNode s, ListNode e) {
        ListNode x = e.next;
        ListNode pre = null, cur = s, next = s.next;
        while (cur != x) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        s.next = x;
    }

    // 获取一组的最后一个节点,不够k个的话返回null
    private ListNode getGroupLastNode(ListNode h, int k) {
        for (int i = 1; i < k; i++) {
            h = h.next;
            if (h == null) {
                return null;
            }
        }
        return h;
    }

    // 获取链表的长度
    private int getNodeLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
    }
}
