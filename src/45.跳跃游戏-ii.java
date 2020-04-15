/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {

        // 贪心算法，end表示当前能跳的边界，到了边界就更新边界
        int end = 0;
        int maxPos = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {// 开始时候是滴0个位置，step已经加1了
            //如果i<length，i遍历到最后会进入if语句就会加1
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {// 如果遇到边界就更新边界，并且步数加1
                end = maxPos;
                step++;

            }
        }
        return step;
    }
}
// @lc code=end
