/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        // 首先要判断是否有效
        // if (!isValid(s, p))
        //     return false;
        int lens = s.length();
        int lenp = p.length();
        boolean[][] dp = new boolean[lens + 1][lenp + 1];// 返回的是加1
        dp[lens][lenp] = true;
        for (int i = lens; i >= 0; i--) {
            for (int j = lenp - 1; j >= 0; j--) { // 这里为啥要减1呢？
                boolean firstMatch = (i < lens && (s.charAt(i) == p.charAt(j)|| p.charAt(j) == '.'));//这里出问题了
                // 两种情况，一种p+1位*，一种p+1不为*
                if (j + 1 < lenp && p.charAt(j + 1) == '*') {
                    // 两种情况，一种s与p匹配上了，后序只要有一个匹配上，都能返回true；????????
                    // 另外一种s与p没匹配上，直接让s与p+2进行比较
                    dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }

            }
        }
        return dp[0][0];

    }

    // public boolean isValid(String s, String p) {
    //     for (char c : s.toCharArray()) {
    //         if (c - '0' > 26 && c - '0' <= 0) {
    //             return false;
    //         }
    //     }
    //     for (char c : p.toCharArray()) {
    //         if (c - '0' > 26 && c - '0' <= 0 || c != '*' || c != '.') {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
// @lc code=end
