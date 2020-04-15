import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    private int m, n;
    private int[][] visited = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };// 右，下，左，上
    private boolean[][] used;
    public List<Pair<Integer, Integer>> resultList = new ArrayList<>();// java中pair的使用方法
    boolean isOpenStack = false;

    public void solve(char[][] board) {
        // 这个题用深度搜索？判断每个0 是否与边界进行相交
        // 这种题 跟fill的思路类似
        if (board == null)
            return;
        m = board.length;
        if (m == 0)
            return;
        n = board[0].length;
        if (n == 0)
            return;
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !used[i][j]) {
                    ArrayList<Pair<Integer, Integer>> openBlock = new ArrayList<>();
                    searchZeroBlock(board, i, j, openBlock);
                    if (!isOpenStack) {
                        resultList.addAll(openBlock);
                    }
                    isOpenStack = false;
                }
            }
        }
        for (int i = 0; i < resultList.size(); i++) {
            Pair<Integer, Integer> cell = resultList.get(i);
            if (cell != null && cell.getKey() != null && cell.getValue() != null) {
                board[cell.getKey()][cell.getValue()] = 'X';
            }
        }

    }

    public boolean isEdge(int x, int y) {// 是否在边界上
        return x == 0 || x == m - 1 || y == 0 || y == n - 1;
    }

    public boolean isArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public void searchZeroBlock(char[][] board, int startX, int startY, List<Pair<Integer, Integer>> result) {
        used[startX][startY] = true;
        if (board[startX][startY] == 'O') {
            Pair<Integer, Integer> pair = new Pair(startX, startY);
            result.add(pair);
            if (isEdge(startX, startY)) {
                isOpenStack = true;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = startX + visited[i][0];
                int nextY = startY + visited[i][1]; // 这里的方向要搞定
                if (isArea(nextX, nextY) && !used[nextX][nextY] && board[nextX][nextY] == 'O') {
                    searchZeroBlock(board, nextX, nextY, result);
                }
            }
        }
    }

}
// @lc code=end
