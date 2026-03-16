package class34;

// 返回两个无环链表相加的第一个节点
public class Code01_IntersectionOfTwoLinkedLists {

    // 节点类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode startA = headA; // A的头节点
        ListNode startB = headB; // B的头节点
        int lenA = 1;
        int lenB = 1;
        while (startA.next != null) {
            lenA++;
            startA = startA.next;
        }
        while (startB.next != null) {
            lenB++;
            startB = startB.next;
        }
        // 判断两个链表的尾节点是否相等,如果不相等的话则一定不相交
        if (startA != startB) {
            return null;
        }
        ListNode longNode = lenA >= lenB ? headA : headB;
        ListNode shortNode = lenA >= lenB ? headB : headA;
        // 先让长的链表先走|lenA-lenB|步
        for (int i = 1; i <= Math.abs(lenA - lenB); i++) {
            longNode = longNode.next;
        }
        while (longNode != null) {
            if (longNode == shortNode) {
                return longNode;
            }
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return null;
    }
}
