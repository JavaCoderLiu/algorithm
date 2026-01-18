package class006;

public class FindPeakElement {
    // 峰值元素是指其值严格大于左右相邻值的元素
    // 给你一个整数数组 nums，已知任何两个相邻的值都不相等
    // 找到峰值元素并返回其索引
    // 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
    // 你可以假设 nums[-1] = nums[n] = 无穷小
    // 你必须实现时间复杂度为 O(log n) 的算法来解决此问题
    public static void main(String[] args) {
        // 测试链接 : https://leetcode.cn/problems/find-peak-element/
        class Solution {
            public static int findPeakElement(int[] nums) {
                // 当nums[0] > nums[1],return 0
                // 当nums[length - 1] > nums[length - 2],return length - 1
                // 上述条件都不满足时,判断数组中间的数是否小于左侧的数,左边继续二分;再继续判断是否小于右侧的数,右边继续二分,反之中间的数就是峰值
                if (nums.length == 1) {
                    return 0;
                }
                int l = 0, r = nums.length - 1, m = 0;
                if (nums[l] > nums[l + 1]) {
                    return l;
                }
                if (nums[r] > nums[r - 1]) {
                    return r;
                }
                // 记得更新l和r l = l + 1,r = r - 1
                l++;
                r--;
                while (l <= r) {
                    m = (l + r) >> 1;
                    if (nums[m] < nums[m - 1]) {
                        r = m - 1;
                    } else if (nums[m] < nums[m + 1]) {
                        l = m + 1;
                    } else {
                        return m;
                    }
                }
                return -1;
            }
        }
    }
}
