/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {// 
        if (s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) { //，
            if (s.charAt(i - 1) == '0') {// 为0的情况要单独计算
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;// 否则格式不正确
                }
            } else {
                if (s.charAt(i - 2) == '1'
                        || (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '6')) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end
