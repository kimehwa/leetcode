/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // y一共有多少种路径
        // int[][] dp = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     dp[i][0] = 1;
        // }
        // for (int j = 0; j < n; j++) {
        //     dp[0][j] = 1;
        // }
        // for (int i = 1; i < m; i++) {
        //     for (int j = 1; j < n; j++) {
        //         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //     }
        // }
        // return dp[m - 1][n - 1];
        // ========转化为1维的试一下=========
       
        int[] dp = new int[n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i==0||j==0) dp[j]=1;
                else dp[j]=dp[j-1]+dp[j];
            }
        }
        return dp[n-1];
    }
}
// @lc code=end
