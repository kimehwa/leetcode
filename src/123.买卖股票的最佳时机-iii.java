/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 最多可以完成两笔交易，三种状态，一种是天数，一种是交易次数k，一种是持有或者没持有
        //然后写出来方程。然后搞定base状态
        int dpi_1_0 = 0, dpi_1_1 = Integer.MIN_VALUE, dpi_2_0 = 0, dpi_2_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dpi_1_0 = Math.max(dpi_1_0, dpi_1_1 + prices[i]);
            dpi_1_1 = Math.max(-prices[i], dpi_1_1);
            dpi_2_0 = Math.max(dpi_2_0, dpi_2_1 + prices[i]);
            dpi_2_1 = Math.max(dpi_1_0 - prices[i], dpi_2_1);
        }
        return dpi_2_0;
    }
}
// @lc code=end
