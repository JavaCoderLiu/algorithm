package class25;

public class HeapSort {

    public static void HeapSort1(int[] nums) {
        // 建立最大堆
        HeapInsert(nums);
        // 将最大堆调整为有序数组
        int size = nums.length;
        while (size > 0) {
            swap(0, --size, nums);
            heapIfy(0, nums, size);
        }
    }

    public static void HeapSort2(int[] nums) {
        // 建立最大堆
        for (int i = nums.length - 1; i >= 0; i--) {
            heapIfy(i, nums, nums.length);
        }
        int size = nums.length;
        while (size > 0) {
            swap(0, --size, nums);
            heapIfy(0, nums, size);
        }
    }

    /**
     * 从前往后建立最大堆
     *
     * @param nums
     */
    public static void HeapInsert(int[] nums) {
        int size = 0;
        // 依次插入节点
        for (int i = 0; i <= nums.length - 1; i++) {
            int temp = i;
            // 如果当前节点的值一直比父节点的值要大,则往上冲
            while (nums[temp] > nums[(temp - 1) / 2]) {
                // 交换当前节点和父节点的值
                swap(temp, (temp - 1) / 2, nums);
                temp = (temp - 1) / 2;
            }
        }
    }

    /**
     * 数组i处值变化,要求仍然维持最大堆
     * 往下比较
     *
     * @param i
     * @param nums
     * @param size
     */
    public static void heapIfy(int i, int[] nums, int size) {
        // 左孩子下标
        int l = i * 2 + 1;
        while (l < size) {
            // best表示左右孩子中数值比较大的下标,(l + 1) < size:表示判断是否右孩子存在
            int best = (l + 1) < size && nums[l + 1] > nums[l] ? l + 1 : l;
            if (nums[i] >= nums[best]) {
                break;
            } else {
                swap(best, i, nums);
                i = best;
                l = i * 2 + 1;
            }
        }
    }

    public static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6};
        HeapSort1(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

}
