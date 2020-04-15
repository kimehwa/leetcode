/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) >>> 1;
        while (left <= right) {
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;// 否则只能从右边走
                }
            } else {
                if (nums[mid] <= target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            mid = (left + right) >>> 1;
        }

        return -1;
    }
}
// @lc code=end
