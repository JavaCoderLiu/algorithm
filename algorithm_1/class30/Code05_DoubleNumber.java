package class30;

public class Code05_DoubleNumber {

    public int[] singleNumber(int[] nums) {
        // allXor = a ^ b;因为a和b肯定不一样,因此a^b的二进制表示中一定有1,在有1的位置中,a和b一定是不一样的
        // 此时我们可以按照这个位置为1/0划分两个阵营
        int allXor = 0;
        for (int num : nums) {
            allXor ^= num;
        }
        int rightOne = allXor & (-allXor);
        int partXor = 0;
        for (int num : nums) {
            if ((num & rightOne) == 0) partXor ^= num;
        }
        int a = allXor ^ partXor;
        int b = allXor ^ a;
        return new int[]{a, b};
    }
}
