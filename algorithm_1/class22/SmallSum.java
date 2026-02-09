package class22;

import java.util.Scanner;

public class SmallSum {

    public static int MAX = 100001;

    public static int[] arr = new int[MAX];

    public static int[] help = new int[MAX];

    public static int n;

    // 求解[l,r]数组的小和
    public static long smallSum(int l, int r) {
        if (l == r) return 0;
        int m = (l + r) / 2;
        // 递归求解左数组和右数组的小和以及跨越左右的小和
        return smallSum(l, m) + smallSum(m + 1, r) + merge(l, r, m);
    }

    // 先统计,再将[l,r]变得有序
    public static long merge(int l, int r, int m) {
        long ans = 0;
        for (int i = l, j = m + 1, sum = 0; j <= r; j++) {
            // 当左侧指针一直在m之前且左侧数小于右侧数,则左指针移动
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }
        // 合并有序数组
        int a = l;
        int b = m + 1;
        int i = l;
        // 依次选择两段数组中较小数,并往后移
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        // 最后再更新数组
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
        System.out.println(smallSum(0, n - 1));
    }

}
