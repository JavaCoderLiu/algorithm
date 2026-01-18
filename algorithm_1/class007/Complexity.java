package class007;

/*Complexity:表示复杂度的意思
 * Time Complexity:时间复杂度
 * Space Complexity:空间复杂度
 * */
public class Complexity {
    /*
     * 时间复杂度:只要高阶项,不要低阶项 不要常数项
     * 严格固定流程的算法,要强调最差情况 例如插入排序,最好的情况是O(n),最坏是O(n^2)
     * 算法流程上利用随机行为作为重要部分的,要看平均或者期望的时间复杂度,因为最差的时间复杂度无意义生成相邻值不同的数组
     * 不要用代码结构来判断时间复杂度比如只有一个while循环的冒泡排序，其实时间复杂度O(N^2)
     * 不要用代码结构来判断时间复杂度，比如:N/1 + N/2 + N/3 + … + N/N，这个流程的时间复杂度是O(N * logN)，著名的调和级数
     * 时间复杂度的均摊,用动态数组的扩容来说明(等比数列、均摊的意义)并查集 单调队列 单调栈 哈希表等结构 均有这个概念
     * */

    /*生成长度为n,值在0~v-1,且相邻两个数不相等的数组*/
    public static int[] randArray(int n, int v) {
        int[] arr = new int[n];
        arr[0] = (int) (Math.random() * v);
        for (int i = 1; i < n; i++) {
            int num = 0;
            do {
                num = (int) (Math.random() * v);
            } while (num == arr[i - 1]);
            arr[i] = num;
        }
        return arr;
    }

    public static void main(String[] args) {
        int times = 10;
        for (int i = 0; i < times; i++) {
            int[] ints = randArray(5, 10);
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        int N = 200000;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j = j + i) {

            }
        }
        long end = System.currentTimeMillis();
        System.out.println("总计:" + (end - start) + "毫秒");
        start = System.currentTimeMillis();
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {

            }
        }
        end = System.currentTimeMillis();
        System.out.println("总计:" + (end - start) + "毫秒");

    }
}
