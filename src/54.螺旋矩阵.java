import java.util.ArrayList;
import java.util.List;

import javafx.scene.transform.MatrixType;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        
        
        if (matrix == null || matrix.length == 0)
            return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int tr = 0, tc = 0, dr = m - 1, dc = n - 1;
        // 统计
        while(tr<=dr&&tc<=dc){
            process(matrix, tr++, tc++, dr--, dc--);
        }
        return res;
    //     if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
    //         return new LinkedList<>();
    //     int l = 0;
    //     int r = matrix[0].length - 1;
    //     int u = 0;
    //     int d = matrix.length - 1;
    //     List<Integer> list = new LinkedList<>();
    //     while (l <= r && u <= d){
    //         for (int i = l; i <= r; i++) {
    //             list.add(matrix[u][i]);
    //         }
    //         u++;//这儿已经跑到下一行了
    //         for (int i = u; i <= d; i++) {
    //             list.add(matrix[i][r]);//这儿的关键是怎么回事
    //         }
    //         r--;
    //         for (int i = r; i >= l && u <= d; i--) {
    //             list.add(matrix[d][i]);
    //         }
    //         d--;
    //         for (int i = d; i >= u && l <= r; i--) {
    //             list.add(matrix[i][l]);
    //         }
    //         l++;
    //     }
    //    return list;                     

    }
    public void process(int[][] m,int tr,int tc,int dr,int dc){
        
        for(int i=tc;i<dc;i++){
            res.add(m[tr][i]);
        }
        for(int i = tr;i<dr;i++){
            res.add(m[i][dc]);
        }
        for(int i = dc;i>tc&&tc<dc;i--){
            res.add(m[dr][i]);
        }
        for(int i = dr;i>tr;i--){
            res.add(m[i][tc]);
        }
        
    }
}
// @lc code=end
