public class Class003Binary {
    /**
     * 打印int类型的二进制表示
     * @param num int整数
     */
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printBinary(88);
        printBinary(-8);
    }
}
