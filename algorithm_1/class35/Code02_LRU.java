package class35;

import java.util.HashMap;

// 实现LRU
public class Code02_LRU {

    class LRUCache {

        class DoubleNode {
            public int key;
            public int value;
            public DoubleNode last;
            public DoubleNode next;

            public DoubleNode(int k, int v) {
                key = k;
                value = v;
            }
        }

        class DoubleList {

            private DoubleNode head;
            private DoubleNode tail;

            public DoubleList() {
                head = null;
                tail = null;
            }

            public void addNode(DoubleNode newNode) {
                if (newNode == null) {
                    return;
                }
                if (head == null) {
                    head = newNode;
                } else {
                    tail.next = newNode;
                    newNode.last = tail;
                }
                tail = newNode;
            }

            public void moveNodeToTail(DoubleNode node) {
                // 头节点
                if (head == node) {
                    tail.next = node;
                    node.last = tail;
                    node.next.last = null;
                    head = node.next;
                    node.next = null;
                    tail = node;
                    return;
                }
                // 尾节点
                if (tail == node) {
                    return;
                }
                tail.next = node;
                node.last.next = node.next;
                node.next.last = node.last;
                node.last = tail;
                tail = node;
            }

            public DoubleNode removeHead() {
                if (head == null) {
                    return null;
                }
                DoubleNode ans = head;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = head.next;
                    head.last = null;
                }
                return ans;
            }
        }

        private HashMap<Integer, DoubleNode> keyNodeMap;

        private DoubleList nodeList;

        private final int capacity;

        public LRUCache(int cap) {
            keyNodeMap = new HashMap<>();
            nodeList = new DoubleList();
            capacity = cap;
        }

        public int get(int key) {
            if (!keyNodeMap.containsKey(key)) {
                return -1;
            }
            DoubleNode node = keyNodeMap.get(key);
            nodeList.moveNodeToTail(node);
            return node.value;
        }

        public void put(int key, int value) {
            // 判读是否存在
            if (!keyNodeMap.containsKey(key)) {
                DoubleNode node = new DoubleNode(key, value);
                if (capacity == keyNodeMap.size()) {
                    // 删除再增加
                    DoubleNode removedNode = nodeList.removeHead();
                    keyNodeMap.remove(removedNode.key);
                }
                nodeList.addNode(node);
                keyNodeMap.put(key, node);
            } else {
                DoubleNode node = keyNodeMap.get(key);
                node.value = value;
                nodeList.moveNodeToTail(node);
            }
        }
    }

}
