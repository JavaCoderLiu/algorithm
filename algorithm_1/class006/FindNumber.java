package class006;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindNumber {

    /*生成有序数组*/
    public static int[] randArray(int length, int v) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            // 生成一个[1,v]的随机整数Math.random()->[0,1)*v->[0,v)+1->[1,v+1)->[1,v]
            int randNum = (int) (Math.random() * v + 1);
            result[i] = randNum;
        }
        Arrays.sort(result);
        return result;
    }

    /*使用二分查找num是否存在*/
    private static boolean exist(int[] arr, int num) {
        // 特殊情况判断
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0, r = arr.length - 1, m = 0;
        while (l <= r) {
            // 正常情况可以这么写,但是也可以这么写m = l + (r - l) / 2;为了避免l + r过大导致溢出
            m = (l + r) / 2;
            if (num > arr[m]) {
                l = m + 1;
            } else if (num < arr[m]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean existByFor(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        // 直接从左往右依次遍历
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print(arr[i]);
            } else {
                System.out.print(" " + arr[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTimes = 100, length = 20, v = 200, num = 13;
        for (int i = 0; i < testTimes; i++) {
            System.out.println("-----第" + (i + 1) + "轮测试-----");
            int[] randArray = randArray(length, v);
            print(randArray);
            if (exist(randArray, num) == existByFor(randArray, num)) {
                System.out.println("测试通过");
            } else {
                System.out.println("测试失败");
            }
        }
    }

}
