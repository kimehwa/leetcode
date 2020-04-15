/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        // dp进行处理，这个的状态转移方程是？其中检查是否是回文数，可以用动态规划的方法处理
        // 这个状态转移方程要枚举所有已经算出j的值的位置了
        // dp[i] = min([dp[j] + 1 for j in range(i) if s[j + 1, i] 是回文])
        int len = s.length();
        if (len < 2)
            return 0;
        int[] dp = new int[len]; // 写状态转移方程
        for (int i = 0; i < len; i++) {
            dp[i] = i;// 默认设置为dp的最大值 每一次都进行分割
        }
        // 参考第五题：最长回文子串的动态规划的解法
        boolean[][] checkPalindrome = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {// 这里的取等号表示一个字符也需要添加
                if (s.charAt(left) == s.charAt(right) && (right - left < 2 || checkPalindrome[left + 1][right - 1])) {
                    checkPalindrome[left][right] = true;
                }
            }
        }
        // 一个字符的时候，不用判断
        for (int i = 1; i < len; i++) {
            if (checkPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {// 为了保证j+1：i中至少有一个字符串
                if (checkPalindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[len - 1];

    }
}
// @lc code=end
