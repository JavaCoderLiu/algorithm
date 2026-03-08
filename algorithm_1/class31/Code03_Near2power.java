package class31;

public class Code03_Near2power {

    public static final int near2power(int n) {
        if (n <= 0) {
            return 1;
        } else {
            n--;
            n |= n >>> 1;
            n |= n >>> 2;
            n |= n >>> 4;
            n |= n >>> 8;
            n |= n >>> 16;
            return n + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(near2power(17));
    }

}
