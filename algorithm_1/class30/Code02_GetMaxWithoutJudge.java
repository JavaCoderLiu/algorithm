package class30;

// 不用任何判断语句和比较操作返回两个数的最大值
public class Code02_GetMaxWithoutJudge {

    /**
     * ,<--></-->
     *
     * @param num
     * @return
     */
    public static int flip(int num) {
        return 1 ^ num;
    }

    /**
     * 求num的符号,本来如果num为非负数则符号位为0,那么符号为1,反之亦然
     *
     * @param num
     * @return
     */
    public static int getSign(int num) {
        // 无符号右移31位,左边全部补0,如果是有符号右移可能会补1
        return flip(num >>> 31);
    }

    public static int getMax(int a, int b) {
        // 如果当a和b的符号不同时,有可能溢出
        int c = a - b;
        // 1.a和b的符号相同且c为非负数 -> a
        // 2.a和b的符号不同且a为非负数 -> a
        // 反之则为b
        int signA = getSign(a);
        int signB = getSign(b);
        int signC = getSign(c);
        int diffAB = signA ^ signB;
        int sameAB = flip(signA ^ signB);
        int returnA = sameAB * signC + diffAB * signA;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        System.out.println(getMax(a, b));
    }

}
