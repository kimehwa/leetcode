/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, d = 0, c = n - 1;
        int[][] res = new int[n][n];
        int num = 1, target = n * n;
        while (num <= target) {
            for (int i = l; i <= r; i++)
                res[d][i] = num++;// 左边到右边
            d++;
            for (int i = d; i <= c; i++)
                res[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--)
                res[c][i] = num++;
            c--;
            for (int i = c; i >= d; i--)
                res[i][l] = num++;
            l++;

        }
        return res;
    }
}
// @lc code=end
