public class Class004SelectBubbleInsertSort {

    /*数组中交换i和j位置的数*/
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*打印*/
    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /*选择排序:在i~n-1范围上,找到最小值并放到i位置,然后在i+1~n-1范围上继续*/
    public static int[] selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    /*冒泡排序:0~i范围上,相邻位置较大的数滚下去,最大值来到i位置,然后0~i-1范围上继续*/
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    /*0~i范围上已有序,新来的数从右到左依次滑,直到左边没数或者不小于左边的数,然后继续*/
    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j - 1 >= 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j-1, j);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 3};
        print(arr);
        System.out.println();
        print(insertSort(arr));
    }
}
