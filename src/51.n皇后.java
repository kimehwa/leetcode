import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    // 用于标记是否被列方向的皇后攻击 2主对角线的攻击，3次对角线的攻击
    int[] rows;
    int[] mains;// 因为原点是左上角 ，所以mian为行号加列号，每一个点都有一个不同的对角线
    int[] secondary;// 两个对角线都是用一行进行搞定？每一个对角线的行号加列号都是一个固定的值且相等
    int[] queens;
    int n;
    private List<List<String>> output = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 也是回溯的问题
        rows = new int[n];
        mains = new int[2 * n - 1];
        secondary = new int[2 * n - 1];
        queens = new int[n];
        this.n = n;
        dfs(0);// 从0位置开始遍历
        return output;

    }

    public void dfs(int row) {
        if (row >= n)
            return;
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                if (row == n - 1)
                    addSolution();// 当当前行是最后一行 找到了一个解决方案
                dfs(row + 1);// 下一行放置皇后
                removeQueen(row, col); // 回溯这一行
            }
        }

    }

    public boolean isNotUnderAttack(int row, int col) {
        // 主对角线和次对角线都是一个一次方程,因为从行进行dfs，所以我们没必要判读行的了
        // 分别为列 主对角线
        int res = rows[col] + mains[row - col + n - 1] + secondary[row + col];
        return res == 0;

    }

    public void placeQueen(int row, int col) {
        queens[row] = col;
        rows[col] = 1;
        mains[row - col + n - 1] = 1; // 主对角线方向有,加上n-1防止越界；
        secondary[row + col] = 1;
    }

    public void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        mains[row - col + n - 1] = 0; // 主对角线方向有,加上n-1防止越界；
        secondary[row + col] = 0;
    }

    public void addSolution() {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int col = queens[i];
            // 因为每一行只能有一个Q,所以新建一个sb
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                sb.append(".");
            }
            sb.append("Q");
            for (int j = 0; j < n - col - 1; j++) {
                sb.append(".");
            }
            solution.add(sb.toString());
        }
        output.add(solution);
    }
}
// @lc code=end
