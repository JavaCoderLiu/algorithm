package class30;

public class Code01_SwapExclusiveOr {

    public static void main(String[] args) {
        int a = -2323;
        int b = 10;
        System.out.println(a);
        System.out.println(b);
        System.out.println("=============");
        a = a ^ b;
        b = a ^ b; // (a ^ b) ^ b = a ^ 0 = a
        a = a ^ b; // (a ^ b) ^ a = b
        System.out.println(a);
        System.out.println(b);
    }

}
