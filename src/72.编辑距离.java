/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        // 先定义dp[i][j] 的定义，插入，删除，替换分别对应了三种情况，
        // 一种情况是什么都不做， 当i与j匹配了 2 插入[0...i]与[0,j]匹配了为dp[i][j]
        // 1 插入 插入了一个与j匹配的，然后用i来匹配j-1,因为j已经匹配了 dp[i][j]=dp[i][j-1]+1;
        // 2 删除 删除与j不匹配的 然后比较i-1与j的关系 所以dp[i][j]=dp[i-1][j]+1;
        // 替换 把i替换为j，二者已经匹配 看i-1yuj-1的关系所有，dp[i][j]=dp[i-1][j-1]+1;这个题如何写呢。还可以化为一维的dp
        // 这个题还可以进行空间复杂度的划分，不过这个题看看就行 ，真正的话还是用二维做吧 不容易出错Î
        int s1 = word1.length(), s2 = word2.length();
        int[][] dp = new int[s1 + 1][s2 + 1];
        for (int i = 1; i <= s1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= s2; j++)
            dp[0][j] = j;
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                // 因为是dp从1开始算的，word下标是从0开始的。i与j始终要比其大1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {// 这里出错了 应该为i-1等于j-1
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[s1][s2];

    }
}
// @lc code=end
