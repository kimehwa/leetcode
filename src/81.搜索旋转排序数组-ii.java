/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        // 又是二分法
        if (nums == null || nums.length == 0)
            return false;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target)
                return true;
            if (nums[l] == nums[mid]) {//如果start==mid，分不清哪个有序 直接加1就行
                l++;
                continue;
            }
            if (nums[mid] > nums[l]) {// 说明左半部有序
                if (nums[l] <= target && target < nums[mid]) {// 这里为啥是等于
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) { // 这里为啥是这个
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
// @lc code=end
