package class005;

public class Validator {

    /*数组中交换i和j位置的数*/
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*选择排序:在i~n-1范围上,找到最小值并放到i位置,然后在i+1~n-1范围上继续*/
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
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
    }

    /*冒泡排序:0~i范围上,相邻位置较大的数滚下去,最大值来到i位置,然后0~i-1范围上继续*/
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /*插入排序:0~i范围上已有序,新来的数从右到左依次滑,直到左边没数或者不小于左边的数,然后继续*/
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j - 1 >= 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    /*生成一个长度为length 从[1,V]的数组*/
    public static int[] randomArray(int length, int V) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * V) + 1;
        }
        return arr;
    }

    /*校验两个数组的值是否完全相同*/
    public static boolean isSameValue(int[] arr1, int[] arr2) {
        int length = arr1.length;
        for (int i = 0; i < length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /*拷贝旧数组到一个新的数组*/
    public static int[] copeArray(int[] arr) {
        int[] newArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        System.out.println("测试开始");
        int testTimes = 100;
        int length = 100;
        int Max = 300;
        for (int i = 0; i < testTimes; i++) {
            int[] array = randomArray(length, Max);
            int[] array1 = copeArray(array);
            int[] array2 = copeArray(array);
            int[] array3 = copeArray(array);
            selectSort(array1);
            bubbleSort(array2);
            insertSort(array3);
            if (!isSameValue(array1, array2) || !isSameValue(array1, array3)) {
                System.out.println("出错了");
            }
        }
        System.out.println("测试结束");
    }

}
