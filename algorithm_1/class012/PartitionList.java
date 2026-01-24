package class012;

public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode end = head;
        end.next = new ListNode(4);
        end = end.next;
        end.next = new ListNode(3);
        end = end.next;
        end.next = new ListNode(2);
        end = end.next;
        end.next = new ListNode(5);
        end = end.next;
        end.next = new ListNode(2);
        end = end.next;
        partition(head, 3);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftEnd = null;
        ListNode rightHead = null, rightEnd = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            if (head.val < x) { // 放左边
                if (leftHead == null) { // 第一个元素
                    leftHead = head;
                    head.next = null;
                    leftEnd = head;
                } else {
                    leftEnd.next = head;
                    head.next = null;
                    leftEnd = leftEnd.next;
                }
            } else { // 放右边
                if (rightHead == null) { // 第一个元素
                    rightHead = head;
                    head.next = null;
                    rightEnd = head;
                } else {
                    rightEnd.next = head;
                    head.next = null;
                    rightEnd = rightEnd.next;
                }
            }
            head = next;
        }
        if (leftHead == null) {
            return rightHead;
        } else {
            leftEnd.next = rightHead;
            return leftHead;
        }
    }

}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
