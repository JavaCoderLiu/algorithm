package class010;

public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode head = (list1.val <= list2.val) ? list1 : list2;
        ListNode c1 = head.next;
        ListNode c2 = (head == list1) ? list2 : list1;
        ListNode end = head;
        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                end.next = c1;
                c1 = c1.next;
            } else {
                end.next = c2;
                c2 = c2.next;
            }
            end = end.next;
        }
        if (c1 == null || c2 == null) {
            end.next = (c2 != null) ? c2 : c1;
        }
        return head;
    }

    public static void main(String[] args) {

    }

}

// 链表节点类
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
