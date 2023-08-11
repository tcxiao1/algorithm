package cn.tc.array;
//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。
//
// 示例 1:
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
//
//
// 示例 2:
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
//
//
//
//
// 提示：
//
//
// 你可以假设 nums 中的所有元素是不重复的。
// n 将在 [1, 10000]之间。
// nums 的每个元素都将在 [-9999, 9999]之间。
//
//
// Related Topics 数组 二分查找 👍 1389 👎 0

public class array704 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
//        System.out.println(search(nums, 5));
        System.out.println(search2(nums, 2));
    }

    public static int search(int[] nums, int target) {
        /*
         * 遍历解法
         * */
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
            }
        }
        return index;
    }

    public static int search2(int[] nums, int target) {
        /*
         * 重点左右指针索引的位置  [a,b] 左闭右闭区间
         * */
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    public static int search3(int[] nums, int target) {
        /*
         * 重点左右指针索引的位置  [a,b) 左闭右开区间
         * */
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
