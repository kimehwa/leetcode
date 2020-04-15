/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    // 这个题又是回溯，感觉跟那个4个方向一样
    private boolean[][] marked; // 这种肯定要标记
    private int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };// 上左右下
    private int m;// 行
    private int n;// 列
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0)
            return false;
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start); // 比较最后一个是否相等
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) { // start与word的length一样长
                        return true;
                    }
                }
            }
            marked[i][j] = false; // 这里为啥要进行回溯呢？如果前面都走不同就递归回溯这个地方
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
// @lc code=end
