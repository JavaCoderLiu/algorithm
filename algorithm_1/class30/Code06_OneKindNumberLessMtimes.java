package class30;

public class Code06_OneKindNumberLessMtimes {
    public static int singleNumber(int[] nums) {
        return find(nums, 3);
    }

    public static int find(int[] nums, int m) {
        int[] cnt = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                cnt[j] += 1 & (nums[i] >> j);
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (cnt[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
