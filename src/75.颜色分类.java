/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // 这个题就是荷兰国旗问题 哪里又有问题了
        if (nums == null || nums.length < 2)
            return;
        int left = -1, right = nums.length, i = 0;
        while (i < right) {//这里出了问题，左一定跟右碰不到啊不是left<right
            if (nums[i]== 2) {
                swap(nums, i, --right);
            } else if (nums[i] == 0) {
                swap(nums, i++, ++left);
            } else {
                i++;
            }
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end
