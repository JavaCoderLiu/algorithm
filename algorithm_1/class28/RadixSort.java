package class28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

    public static int BASE = 10;

    public static int MAXN = 50001;

    public static int[] help = new int[MAXN];

    public static int[] wsz = new int[BASE];

    public static int Min, Max;

    public static int[] sortArray(int[] arr) {
        if (arr.length > 1) {
            Min = arr[0];
            // 获取原数组最小值是为了让原数组都是非负数
            for (int i : arr) {
                Min = Math.min(i, Min);
            }
            Max = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= Min;
                Max = Math.max(Max, arr[i]);
            }
            // 获取位数
            int bits = bits(Max);
            RadixSort(arr, arr.length, bits);
            // 忘记了还原原数组
            for (int i = 0; i < arr.length; i++) {
                arr[i] += Min;
            }
        }
        return arr;
    }

    public static void RadixSort(int[] arr, int length, int bits) {
        int time = 1;
        for (int i = 0; i < bits; i++, time *= BASE) {
            // 忘记了将wsz数组清空
            Arrays.fill(wsz, 0);
            for (int j = 0; j < length; j++) {
                wsz[(arr[j] / time) % BASE]++;
            }
            for (int j = 1; j < BASE; j++) {
                wsz[j] = wsz[j] + wsz[j - 1];
            }
            for (int j = length - 1; j >= 0; j--) {
                help[--wsz[(arr[j] / time) % BASE]] = arr[j];
            }
            for (int j = 0; j < length; j++) {
                arr[j] = help[j];
            }
        }
    }

    public static int bits(int x) {
        int ans = 0;
        while (x != 0) {
            x /= BASE;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{23, 12, 3, 42, 108, 15, 7, 22};
        arr = sortArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
