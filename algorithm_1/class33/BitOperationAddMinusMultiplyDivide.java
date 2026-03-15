package class33;

public class BitOperationAddMinusMultiplyDivide {

    public static int MIN = Integer.MIN_VALUE;

    /**
     * 加法
     *
     * @param a
     * @param b
     * @return
     */
    public static int add(int a, int b) {
        int ans = a;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    /**
     * 减法
     *
     * @param a
     * @param b
     * @return
     */
    public static int minus(int a, int b) {
        // a-b
        // -b = ~b+1
        return add(a, neg(b));
    }

    /**
     * 相反数
     *
     * @param a
     * @return
     */
    public static int neg(int a) {
        return add(~a, 1);
    }

    /**
     * 乘法
     *
     * @param a
     * @param b
     * @return
     */
    public static int multiply(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((1 & b) == 1) {
                ans = add(ans, a);
            }
            b = b >>> 1;
            a = a << 1;
        }
        return ans;
    }

    // 必须保证a和b都不是整数最小值，返回a除以b的结果
    public static int div(int a, int b) {
        int x = a < 0 ? neg(a) : a;
        int y = b < 0 ? neg(b) : b;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            if ((x >> i) >= y) {
                // i位置设置为1
                ans |= (1 << i);
                x = minus(x, y << i);
            }
        }
        // 单独判断符号位
        return a < 0 ^ b < 0 ? neg(ans) : ans;
    }

    public static int divide(int a, int b) {
        if (a == MIN && b == MIN) {
            return 1;
        }
        if (a != MIN && b != MIN) {
            return div(a, b);
        }
        if (b == MIN) {
            return 0;
        }
        // a是整数最小,b是-1,则返回整数最大值
        if (b == neg(1)) {
            return Integer.MAX_VALUE;
        }
        if (b > 0) {//-1
            a = add(a, b);
            return minus(div(a, b), 1);
        } else if (b < 0) {
            a = minus(a, b);
            return add(div(a, b), 1);
        } else {
            return neg(-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(add(1, -4));
        System.out.println(minus(1, 3));
        System.out.println(multiply(-2, -3));
        System.out.println(divide(MIN, -1));
    }
}
