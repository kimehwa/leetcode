/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        // 这些dp的思路是什么啊，卡特兰数，完成了与n为1与i有关的公式
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {// 这两个都能取等号
                dp[i] += dp[j - 1] * dp[i - j]; // 这里就像1+。。。+100的时候几乎一样
            }
        }
        return dp[n];
    }
}
// @lc code=end
