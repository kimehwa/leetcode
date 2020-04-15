/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // 这个题dp思想，左神的一个题，我当时还看了的！一点也不记得了
        // dp[i][j]的含义是从i，j开始出发 走到末尾需要的最小血量
        // i，j可以根据右下的两个dp进行推导得知 ，并且不能小于1
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 1; // 最低需要1个血量
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        // 这个递推是从后往前递推
        int[][] dp = new int[row--][col--];
        dp[row][col] = dungeon[row][col] > 0 ? 1 : 1 - dungeon[row][col];// 给初始情况赋值
        // 给两个边界情况赋值
        for (int j = col - 1; j >= 0; j--) {
            dp[row][j] = Math.max(dp[row][j + 1] - dungeon[row][j], 1);
        }
        // 第二个边界情况可以赋值到第一个循环中
        int right = 0;
        int down = 0;
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(dp[i + 1][col] - dungeon[i][col], 1);
            for (int j = col - 1; j >= 0; j--) {
                right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];

    }
}
// @lc code=end
