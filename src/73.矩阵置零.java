import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        // 方法，采用两个hashmap一个记录行信息，一个记录列信息，并不是一个 是所有的行与列
        // int R = matrix.length;
        // int C = matrix[0].length;
        // Set<Integer> rows = new HashSet<>();
        // Set<Integer> cols = new HashSet<>();
        // for (int i = 0; i < R; i++) {
        //     for (int j = 0; j < C; j++) {
        //         if (matrix[i][j] == 0) {
        //             rows.add(i);
        //             cols.add(j);
        //         }
        //     }
        // }
        // for (int i = 0; i < R; i++) {
        //     for (int j = 0; j < C; j++) {
        //         if (rows.contains(i) || cols.contains(j)) {//并不是与的关系，只要有一个就可以了，与的话跟上面就一样了
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
        

    }
}
// @lc code=end
