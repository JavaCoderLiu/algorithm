package class006;

import java.util.Arrays;

public class FindRight {

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

    public static int findRight(int[] arr, int num) {
        int l = 0, r = arr.length - 1, m = 0, ans = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m] <= num) {
                ans = m;
                // 在右侧继续二分
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    /*有序数组中寻找<=num的最右位置*/
    public static void main(String[] args) {
        int testTimes = 10, num = 34, length = 20, v = 60;
        for (int i = 0; i < testTimes; i++) {
            System.out.println("-----第" + (i + 1) + "轮测试-----");
            int[] randArray = randArray(length, v);
            print(randArray);
            System.out.println(findRight(randArray, num));
        }
        int[] nums = {1, 2, 5, 14, 23, 34, 34, 34};
        System.out.println(findRight(nums, 34));
    }

}
