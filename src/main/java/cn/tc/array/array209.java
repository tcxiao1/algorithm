package cn.tc.array;

public class array209 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen2(7, nums));
    }


    public static int minSubArrayLen(int target, int[] nums) {

        /*
         * 暴力求解
         *
         * */
        int res = 0;
        int k = 1; //区间

        int l = 0;
        int r = 0;
        boolean skip = false;

        int sum = 0;
        while (k <= nums.length) {

            while (r < nums.length) {
                for (int i = l; i <= r; i++) {
                    sum = sum + nums[i];
                }

                if (sum >= target) {
                    res = k;
                    skip = true;
                    break;
                } else {
                    sum = 0;
                }
                r++;
                l++;
            }

            if (skip) {
                break;
            }

            l = 0;
            r = l + k;
            k++;
        }

        return res;
    }


    public static int minSubArrayLen2(int target, int[] nums) {
        /*
         * 双指针
         *
         * 需要定义遍历指针后节点结束
         *
         * 重点:连续子数组
         * */

        int res = 0; //区间

        int left = 0;
        int right = 0;

        int sum = 0;
        while (right < nums.length) {

            sum = sum + nums[right];

            while (sum >= target) {
                int k = right - left + 1;
                if (res == 0) {
                    res = k;
                } else {
                    res = Math.min(k, res);
                }
                sum = sum - nums[left];
                left++;
            }
            right++;
        }

        return res;
    }
}

//给定一个含有 n 个正整数的数组和一个正整数 target 。
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。
//
//
//
// 示例 1：
//
//
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//
// 示例 2：
//
//
//输入：target = 4, nums = [1,4,4]
//输出：1
//
//
// 示例 3：
//
//
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= target <= 10⁹
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁵
//
//
//
//
// 进阶：
//
//
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
//
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1815 👎 0

