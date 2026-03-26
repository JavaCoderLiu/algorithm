package class35;

import java.util.HashMap;
import java.util.HashSet;

public class Code07_AllO1 {

    class AllOne {

        // 哈希桶
        class Bucket {
            public HashSet<String> set;
            public int cnt;
            public Bucket pre;
            public Bucket next;

            public Bucket(String key, int cnt) {
                set = new HashSet<>();
                set.add(key);
                this.cnt = cnt;
            }

            public void remove(Bucket bucket) {
                Bucket pre = bucket.pre;
                Bucket next = bucket.next;
                pre.next = next;
                next.pre = pre;
            }

            public void insert(Bucket bucket, Bucket pre) {
                bucket.next = pre.next;
                pre.next.pre = bucket;
                pre.next = bucket;
                bucket.pre = pre;
            }

        }

        public HashMap<String, Bucket> map;

        public Bucket head;

        public Bucket tail;

        public AllOne() {
            head = new Bucket("", 0);
            tail = new Bucket("", Integer.MAX_VALUE);
            head.next = tail;
            tail.pre = head;
            map = new HashMap<>();
        }

        public void inc(String key) {
            // 首先判断key是否在map中存在
            if (map.containsKey(key)) {
                Bucket bucket = map.get(key);
                int cnt = bucket.cnt;
                // 如果存在cnt+1的桶则直接放进去
                if (cnt + 1 == bucket.next.cnt) {
                    bucket.next.set.add(key);
                    map.put(key, bucket.next);
                } else {
                    Bucket newBucket = new Bucket(key, cnt + 1);
                    map.put(key, newBucket);
                    newBucket.insert(newBucket, bucket);
                }
                // 删除之前桶中的元素
                // 如果桶中没有元素了则删除这个桶
                bucket.set.remove(key);
                if (bucket.set.isEmpty()) {
                    bucket.remove(bucket);
                }
            } else {
                // 如果存在计数为1的桶,直接放到这个桶里
                if (1 == head.next.cnt) {
                    Bucket bucket = head.next;
                    bucket.set.add(key);
                    map.put(key, bucket);
                } else {
                    Bucket newBucket = new Bucket(key, 1);
                    newBucket.insert(newBucket, head);
                    map.put(key, newBucket);
                }
            }
        }

        public void dec(String key) {
            Bucket bucket = map.get(key);
            if (bucket.cnt == 1) {
                map.remove(key);
            } else {
                if (bucket.cnt - 1 == bucket.pre.cnt) {
                    bucket.pre.set.add(key);
                    map.put(key, bucket.pre);
                } else {
                    Bucket newBucket = new Bucket(key, bucket.cnt - 1);
                    map.put(key, newBucket);
                    newBucket.insert(newBucket, bucket.pre);
                }
            }
            bucket.set.remove(key);
            if (bucket.set.isEmpty()) {
                bucket.remove(bucket);
            }
        }

        public String getMaxKey() {
            return tail.pre.set.iterator().next();
        }

        public String getMinKey() {
            return head.next.set.iterator().next();
        }
    }

}
