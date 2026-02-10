package class24;

public class RandomizedSelect {

    public static int first, last;

    // 返回nums数组中如果排序好的情况下下标为i的数
    public static int randomizedSelect(int[] nums, int i) {
        int ans = 0;
        for (int l = 0, r = nums.length - 1; l <= r; ) {
            int x = nums[l + (int) (Math.random() * (r - l + 1))];
            // 划分
            partition(l, r, x, nums);
            if (i < first) {
                r = first - 1;
            } else if (i > last) {
                l = last + 1;
            } else {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    public static void partition(int l, int r, int x, int[] nums) {
        int i = l;
        for (first = l, last = r; i <= last; ) {
            if (nums[i] < x) {
                swap(i++, first++, nums);
            } else if (nums[i] == x) {
                i++;
            } else {
                swap(i, last--, nums);
            }
        }
    }

    public static void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    // 返回nums数组中第k大的数
    public int findKthLargest(int[] nums, int k) {
        return randomizedSelect(nums, nums.length - k);
    }

}
