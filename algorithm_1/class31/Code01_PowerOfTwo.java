package class31;

public class Code01_PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        // 小于等于0
        if (n <= 0) {
            return false;
        }
        // 获取最右测为1的状态
        return n == (n & -n);
    }

}
