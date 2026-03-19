package class34;

// 判断链表是否是回文结构
public class Code04_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 1. 用快慢指针找到中点(偶数链表的中点是偏前的那个)
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        // 将1->2->3->3->2->1调整为1->2->3<-3<-2<-1
        // 将1->2->3->2->1调整为1->2->3<-2<-1
        ListNode pre = null;
        ListNode cur = mid;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 依次比较
        boolean result = true;
        ListNode left = head;
        ListNode right = pre;
        while (left != null && right != null) {
            if (left.val != right.val) {
                result = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        // 为了不影响原链表
        cur = pre;
        pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
