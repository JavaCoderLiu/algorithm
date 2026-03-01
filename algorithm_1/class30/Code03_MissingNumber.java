package class30;

public class Code03_MissingNumber {

    public int missingNumber(int[] nums) {
        // nums:0-nums.length-1,实际上所有的数是0-nums.length
        // 部分的数在nums[i]中
        int allXor = 0;
        int partXor = 0;
        for (int i = 0; i < nums.length; i++) {
            allXor ^= i;
            partXor ^= nums[i];
        }
        allXor ^= nums.length;
        return allXor ^ partXor;
    }

    public static void main(String[] args) {

    }
}
