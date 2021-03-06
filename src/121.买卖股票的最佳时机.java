/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        //状态转移方程。
        if(prices==null||prices.length==0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        // dp[0][0]=0;
        // dp[0][1]= Integer.MIN_VALUE;
        for(int i = 0;i<prices.length;i++){
            if(i-1==-1){
                dp[i][0]=0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1] = Math.max(-prices[i], dp[i-1][1]);
        }
        return dp[prices.length-1][0];
    }
}
// @lc code=end

