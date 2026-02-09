package class22;

import java.util.Scanner;

public class ReversePairs {

    public static int MAX = 100001;

    public static int[] arr = new int[MAX];

    public static int[] help = new int[MAX];

    public static int n;

    public static long counts(int l, int r) {
        if (l == r) return 0;
        int m = (l + r) / 2;
        return counts(l, m) + counts(m + 1, r) + merge(l, r, m);
    }

    public static long merge(int l, int r, int m) {
        long ans = 0;
        for (int i = l, j = m + 1, count = 0; i <= m; i++) {
            while (j <= r && (long) arr[i] > (long) 2 * arr[j]) {
                j++;
            }
            ans += j - m - 1;
        }
        int i = l;
        int a = l, b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(counts(0, n - 1));
    }

}
