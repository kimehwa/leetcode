/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        // 估计又是动态规划的题，这个题与其一样。
        // dp数组的含义dp[i][j]s的前i个元素能否被p的前j个元素匹配
        // 状态转移方程：
        // 1. 当 s[i] == p[j]，或者 p[j] == ? 那么 dp[i][j] = dp[i - 1][j - 1];
        // 2. 当 p[j] == * 那么 dp[i][j] = dp[i][j - 1] || dp[i - 1][j] 其中：
        // dp[i][j - 1] 表示 * 代表的是空字符，例如 ab, ab*
        // dp[i - 1][j] 表示 * 代表的是非空字符，例如 abcd, ab*
        // 初始化：
        // 1. dp[0][0] 表示什么都没有，其值为 true
        // 2. 第一行 dp[0][j]，换句话说，s 为空，与 p 匹配，所以只要 p 开始为 * 才为 true
        // 3. 第一列 dp[i][0]，当然全部为 false
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];// 默认是false
        dp[0][0] = true;
        //还要写行与列的状态 列肯定是false
        for(int i = 1;i<=n;i++){
            dp[0][i]=dp[0][i-1]&&p.charAt(i-1)=='*';//行进行处理 第一个为*才是true
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {// 下标问题
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }

            }
        }
        return dp[m][n];

    }
}
// @lc code=end
