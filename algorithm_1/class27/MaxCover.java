package class27;

import java.util.Arrays;

public class MaxCover {

    public static int MAXN = 100001;
    public static int[][] line = new int[MAXN][2];
    public static int n;
    public static int[] heap = new int[MAXN];
    public static int size;

    public static void add(int x) {
        int index = size;
        heap[size] = x;
        size++;
        // 如果我比父亲节点的值要小则上去
        while (heap[index] < heap[(index - 1) / 2]) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void pop() {
        // 交换位置
        swap(0, size - 1);
        size--;
        int i = 0, l = 1;
        // 如果我的左孩子还存在
        while (l < size) {
            int best = (l + 1) < size && heap[l + 1] < heap[l] ? l + 1 : l;
            // 只有当我大于子节点时才下沉
            if (heap[i] > heap[best]) {
                swap(i, best);
                i = best;
                l = 2 * i + 1;
            } else {
                break;
            }
        }
    }

    public static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static int compute() {
        size = 0;
        Arrays.sort(line, 0, n, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (size > 0 && heap[0] <= line[i][0]) {
                pop();
            }
            add(line[i][1]); // 别忘记入堆
            ans = Math.max(size, ans);
        }
        return ans;
    }

}
