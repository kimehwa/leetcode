/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
       //这个最大子序和的动态规划方程
       int[] dp = new int[nums.length];
       dp[0]=nums[0];
       int max = dp[0];
       for(int i =1;i<nums.length;i++){
           dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
           max = Math.max(max, dp[i]);
       } 
       return max;
    }
}
// @lc code=end

