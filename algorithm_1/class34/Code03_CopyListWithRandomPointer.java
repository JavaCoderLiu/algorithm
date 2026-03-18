package class34;

// 复制带随机指针的链表
public class Code03_CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 1->2->3->4->n变成1->1'->2->2'->3->3'->4->4'->n
        initLink(head);
        // 再将1' 2'...的随机指针指定好
        initRandomPointer(head);
        // 分离链表
        return separateLink(head);
    }

    public Node separateLink(Node head) {
        Node result = head.next;
        Node pre = head;
        Node cur = null;
        Node next = null;
        while (pre != null) {
            cur = pre.next;
            next = cur.next;
            if (next == null) {
                cur.next = null;
                pre.next = null;
            } else {
                cur.next = next.next;
                pre.next = next;
            }
            pre = next;
        }
        return result;
    }

    // 1->2->3->4->n变成1->1'->2->2'->3->3'->4->4'->n
    public void initLink(Node head) {
        Node cur = head;
        Node next = null;
        Node n = null;
        while (cur != null) {
            next = cur.next;
            n = new Node(cur.val);
            cur.next = n;
            n.next = next;
            cur = next;
        }
    }

    // 初始化随机指针
    public void initRandomPointer(Node head) {
        Node pre = head;
        Node cur = null;
        Node next = null;
        while (pre != null) {
            cur = pre.next;
            next = cur.next;
            if (pre.random == null) {
                cur.random = null;
            } else {
                cur.random = pre.random.next;
            }
            // 更新位置
            pre = next;
        }
    }

    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int v) {
            val = v;
        }
    }
}
