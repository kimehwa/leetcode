/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        // 果然还是贪心,但是这个dp如何做呢？先写一下回溯
        // 贪心法，从后往前跳，每次都跳最大的
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
        // return dfs(nums, 0);

    }

    public boolean dfs(int[] nums, int pos) {
        if (pos == nums.length - 1)
            return true;
        int furtherPos = Math.min(nums[pos] + pos, nums.length - 1);
        for (int nextpos = pos + 1; nextpos <= furtherPos; nextpos++) {
            if (dfs(nums, nextpos)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
