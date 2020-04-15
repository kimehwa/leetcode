/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // 这种递归改动态规划的问题还是要好好处理一下StringBuILER的用法还是不咋会啊
        // return process(s1, 0, s2, 0,"", s3);
        // ======递归改动态规划======
        // dpij的含义是前i个与前j个可以与s3匹配,完全可以由递归方法总结出来
        if (s3.length() != s1.length() + s2.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1]; // 这里一般都要进行长度加1
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true; // 初始化dp[0][0] 为都为空的情况 ，可以交错组成
                } else if (i == 0) {// 这两个行列就可以在双层循环中完成
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1); // 注意这里要减1与dp进行对应
                } else {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                            || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }
            }
        }
        return dp[s1.length()][s2.length()];

    }

    public boolean process(String s1, int i, String s2, int j, String res, String s3) {
        // 递归方法，为啥sb不好使，然后 这是递归方法
        if (res.equals(s3) && s1.length() == i && s2.length() == j) {
            return true;
        }
        boolean ans = false;
        if (i < s1.length()) {
            ans |= process(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        }
        if (j < s2.length()) {
            ans |= process(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        }
        return ans;
    }
}
// @lc code=end
