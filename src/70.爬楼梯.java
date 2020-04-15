/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // 这个以题斐波那契额数列,这个简单的dp都？
        // if (n == 0)
        //     return 0;
        // if (n == 1)
        //     return 1;
        // if (n == 2)
        //     return 2;
        // int[] dp = new int[n + 1];
        // dp[0] = 0;
        // dp[1] = 1;
        // dp[2] = 2;
        // for (int i = 3; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];
        //写一个空间优化的方法
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int pre=1,cur=2,next=0;
        for(int i=3;i<=n;i++){
            next = cur+pre;
            pre=cur;
            cur=next;
        }
        return next;
    }
}
// @lc code=end
