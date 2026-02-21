package class27;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// 合并k个有序链表
public class MergeKSortedLists {

    public static ListNode mergeLists(ArrayList<ListNode> arrayList) {
        // 自定义比较器
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };
        // 优先队列(最小堆)
        PriorityQueue<ListNode> nodePriorityQueue = new PriorityQueue<>(comparator);
        // 先将所有的列表的头节点入堆
        for (ListNode listNode : arrayList) {
            if (listNode != null) nodePriorityQueue.add(listNode);
        }
        // 如果优先队列为空
        if (nodePriorityQueue.isEmpty()) return null;
        ListNode h = nodePriorityQueue.poll();
        ListNode p = h;
        // 出一个压进去一个
        if (h.next != null) nodePriorityQueue.add(h.next);
        while (!nodePriorityQueue.isEmpty()) {
            p.next = nodePriorityQueue.poll();
            p = p.next;
            if (p.next != null) nodePriorityQueue.add(p.next);
        }
        return h;
    }

    public static void main(String[] args) {
        
    }
}

class ListNode {
    public int val;
    public ListNode next;
}
