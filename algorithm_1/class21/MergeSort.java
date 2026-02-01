package class21;

// 归并排序
public class MergeSort {

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = l, j = m + 1, cur = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                help[cur++] = arr[i++];
            } else {
                help[cur++] = arr[j++];
            }
        }
        while (i <= m) {
            help[cur++] = arr[i++];
        }
        while (j <= r) {
            help[cur++] = arr[j++];
        }
        for (int k = 0; k < help.length; k++) {
            arr[k + l] = help[k];
        }
    }

    // 递归实现归并排序
    public static void mergeSort1(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort1(arr, l, m);
        mergeSort1(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    // 非递归实现归并
    public static void mergeSort2(int[] arr) {
        for (int len = arr.length, l, m, r, step = 1; step < len; step = step << 1) {
            l = 0;
            while (l < len) {
                m = l + step - 1;
                if (m + 1 >= len) {// 没有右边
                    break;
                }
                r = Math.min(len - 1, l + (2 * step) - 1);
                merge(arr, l, m, r);
                l = r + 1;
            }
        }
    }


    // 统一打印方法
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 4, 1, 0, -12, 8, 9, 11};
        System.out.println("排序前");
        print(arr);
        System.out.println("归并排序-递归实现");
        // mergeSort1(arr, 0, arr.length - 1);
        // print(arr);
        System.out.println("归并排序-非递归实现");
        mergeSort2(arr);
        print(arr);
    }

}
