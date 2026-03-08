package class31;

public class Code04_LeftToRightAnd {

    public static int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            int n = right & -right;
            right -= n;
        }
        return right;
    }

    public static void main(String[] args) {
        rangeBitwiseAnd(5, 7);
    }

}
