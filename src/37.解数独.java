/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    // 回溯算法
    int n = 3;// box的大小
    int N = n * n; // 行的大小
    int[][] rows = new int[N][N + 1];// 这里为啥是加1 这三个相当于一个hash表
    int[][] columns = new int[N][N + 1];// 这里为啥是加1
    int[][] boxes = new int[N][N + 1];// 这里为啥是加1
    char[][] board;
    boolean solvedSudoku = false;

    public boolean couldPlace(int d, int row, int col) {
        // 检查是否一个地方被num=d填满了。
        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {
        // 把一个数字填充到里面
        int idx = (row / n) * n + col / n;
        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char) (d + '0');// 这里的转型是否有必要
    }

    public void removeNumber(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';

    }

    public void placeNextNumbers(int row, int col) {
        if ((col == N - 1) && (row == N - 1)) {
            solvedSudoku = true;
        } else {
            if (col == N - 1)
                backtrace(row + 1, 0);// 去下一行
            else
                backtrace(row, col + 1);// 去下一列
        }
    }

    public void backtrace(int row, int col) {
        if (board[row][col] == '.') {
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    if (!solvedSudoku) {
                        removeNumber(d, row, col);
                    }
                }
            }
        } else {
            placeNextNumbers(row, col);
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrace(0, 0);
    }
}
// @lc code=end
