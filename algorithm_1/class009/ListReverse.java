package class009;

public class ListReverse {

    /*反转单列表*/
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode curNext = null;
        ListNode insert = null;
        while (cur != null) {
            curNext = cur.next;
            cur.next = insert;
            insert = cur;
            cur = curNext;
        }
        return insert;
    }

    /*反转双链表*/
    public static DoubleListNode reverseDoubleList(DoubleListNode head) {
        DoubleListNode cur = head;
        DoubleListNode curNext = null;
        DoubleListNode insert = null;
        while (cur != null) {
            curNext = cur.next;
            cur.next = insert;
            cur.last = curNext;// 神之一手,将当前移走的节点的前指针指向下一个需要移走的元素
            insert = cur;
            cur = curNext;
        }
        return insert;
    }

    /*从前往后遍历双向链表*/
    public static void printFromHead(DoubleListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    /*从后往前遍历双向链表*/
    public static void printFromEnd(DoubleListNode end) {
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
    }

    public static void main(String[] args) {
        DoubleListNode head = new DoubleListNode(1);
        head.last = null;
        head.next = null;
        DoubleListNode end = head;
        for (int i = 2; i <= 8; i++) {
            DoubleListNode node = new DoubleListNode(i);
            node.next = null;
            node.last = end;
            end.next = node;
            end = node;
        }
        printFromHead(head);
        System.out.println();
        printFromEnd(end);
        System.out.println("---------------------");
        head = reverseDoubleList(head);
        printFromHead(head);
    }

}

// 单链表节点
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

// 双链表节点
class DoubleListNode {
    public int value;
    public DoubleListNode last;
    public DoubleListNode next;

    public DoubleListNode(int v) {
        value = v;
    }
}
