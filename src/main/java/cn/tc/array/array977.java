package cn.tc.array;

import java.util.Arrays;

public class array977 {
    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        sortedSquares(nums);
    }

    public static int[] sortedSquares(int[] nums) {

        /*
         *
         * 思路:
         * 1.非递减顺序, 升序或者相等的排列, 平方的最大值肯定分布在数组的左右两边
         * 2.基于额外空间存储,平方之后的数据, + 双指针
         *
         *
         * */

        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[nums.length];
        int k = nums.length - 1;
        while (l <= r) {

            int l2 = nums[l] * nums[l];
            int r2 = nums[r] * nums[r];
            if (l2 >= r2) {
                res[k] = l2;
                l++;
            } else {
                res[k] = r2;
                r--;
            }
            k--;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}


//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：
//
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 非递减顺序 排序
//
//
//
//
// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
//
// Related Topics 数组 双指针 排序 👍 852 👎 0

