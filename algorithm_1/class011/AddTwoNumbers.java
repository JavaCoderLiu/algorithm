package class011;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode end = null;
        int carry = 0;
        int sum = 0;
        int val = 0;
        while (l1 != null || l2 != null) { // 只要有一个非空就一直加
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            val = sum % 10;
            carry = sum / 10;
            if (end == null) {
                result = new ListNode(val);
                end = result;
            } else {
                end.next = new ListNode(val);
                end = end.next;
            }
            // 更新l1 l2
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        if (carry == 1) {
            end.next = new ListNode(carry);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode end = l1;
        end.next = new ListNode(4);
        end.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        end = l2;
        end.next = new ListNode(6);
        end.next = new ListNode(4);

        addTwoNumbers(l1, l2);
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
