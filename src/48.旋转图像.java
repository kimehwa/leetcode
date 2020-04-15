/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int tr = 0, tc = 0, dr = matrix.length - 1, dc = matrix[0].length - 1;
        while (tr < dr) {
            rotateEdge(matrix, tr++, tc++, dr--, dc--);
        }

    }

    // 这里进行反转
    public void rotateEdge(int[][] m, int tr, int tc, int dr, int dc) {
        int times = dc - tc;// 总的需要反转的组数
        int temp = 0;
        for (int i = 0; i != times; i++) {
            temp = m[tr][tc + i];
            m[tr][tc + i] = m[dr - i][tc];
            m[dr - i][tc] = m[dr][dc - i];
            m[dr][dc - i] = m[tr + i][dc];
            m[tr + i][dc] = temp;
        }
    }
}
// @lc code=end
