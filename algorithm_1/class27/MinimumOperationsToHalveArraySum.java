package class27;

public class MinimumOperationsToHalveArraySum {

    public static int MAXN = 100001;

    public static long[] heap = new long[MAXN];

    public static int size;

    public static void swap(int i, int j) {
        long temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void heapIfy(int i) {
        int l = i * 2 + 1;
        while (l < size) {
            int best = (l + 1) < size && heap[l + 1] > heap[l] ? l + 1 : l;
            // 只有当我小于子节点时才下沉
            if (heap[i] < heap[best]) {
                swap(i, best);
                i = best;
                l = 2 * i + 1;
            } else {
                break;
            }
        }
    }

    public static int halveArray(int[] nums) {
        size = nums.length;
        long sum = 0;
        int ans = 0;
        // 从后往前建立最大堆
        for (int i = size - 1; i >= 0; i--) {
            long temp = nums[i];
            temp = temp << 20;
            sum += temp;
            heap[i] = temp;
            heapIfy(i);
        }
        sum /= 2;
        for (long minus = 0; minus < sum; ans++) {
            minus += heap[0] / 2;
            heap[0] /= 2;
            heapIfy(0);
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
