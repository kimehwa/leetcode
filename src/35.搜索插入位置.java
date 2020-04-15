/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return 0;
        if (nums[len - 1] < target) {
            return len;
        }
        int left = 0, right = nums.length-1;//这里是从这里进行分析了
        // 退出循环看是否需要对nums[left] 做一次检查
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {//看左边界是否大于其中的数字
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end
