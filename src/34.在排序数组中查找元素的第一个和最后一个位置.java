/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 这个题今天好好理解一下。
        if (nums == null || nums.length == 0) {
            return new int[] { -1, -1 };
        }
        return new int[] { findLeft(nums, target), findRight(nums, target) };

    }

    public int findLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            // 这里的终止条件是l=r终止
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l==nums.length?-1:(nums[l] == target ? l : -1);
    }

    public int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == 0)
            return -1;// 这里加上去防止越界

        return nums[left - 1] == target ? left - 1 : -1;

    }
}
// @lc code=end
