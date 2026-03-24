package class35;

import java.util.PriorityQueue;

public class Code05_MedianFinder {

    class MedianFinder {

        // 存储较小部分数的最大堆
        private PriorityQueue<Integer> maxHeap;

        // 存储较大部分的最小堆
        private PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((a, b) -> {
                return b - a;
            });

            minHeap = new PriorityQueue<>((a, b) -> {
                return a - b;
            });
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            // 平衡最大堆和最小堆
            balance();
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        }

        private void balance() {
            if (Math.abs(maxHeap.size() - minHeap.size()) == 2) {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                } else {
                    maxHeap.add(minHeap.poll());
                }
            }
        }
    }

}
