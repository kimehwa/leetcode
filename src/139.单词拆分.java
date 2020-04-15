/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 不用hash表，直接每个进行比较即可
        // 这个dp 公式我当时写出来了 这个写成一个递归的思路 用hashset写一个递归的思路
        int m = s.length();
        if (m == 0)
            return false;
        boolean[] dp = new boolean[m + 1];// 这里的设置应怎么处理,方便字符串进行处理
        dp[0] = true;
        for (int i = 1; i <= m; i++) {
            for (String w : wordDict) {
                int len = w.length();
                if (i >= len && dp[i - len] == true && s.substring(i - len, i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[m];

    }
}
// @lc code=end
