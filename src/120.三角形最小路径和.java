import java.time.temporal.Temporal;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 用dp进行处理，向左向右如何进行处理呢？，是个双层dp啊，然后在优化一下就ok了
        // 定义状态dp[i][j] 表示第i行第j列的最小路径和
        // if (triangle == null || triangle.size() == 0)
        //     return 0;
        // int row = triangle.size();
        // int col = triangle.get(row - 1).size(); // 找到行与列
        // int[][] dp = new int[row][col];
        // dp[0][0] = triangle.get(0).get(0);
        // int res = Integer.MAX_VALUE;
        // for (int i = 1; i < row; i++) {// 每一个行数
        //     for (int j = 0; j <= i; j++) {
        //         if (j == 0) {
        //             dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
        //         } else if (j == i) {// 说明到了右边界
        //             dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
        //         } else {
        //             dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
        //         }
        //     }
        // }
        // // dp最后一行最小值
        // for (int i = 0; i < col; i++) {
        //     res = Math.min(res, dp[row - 1][i]);
        // }
        // return res;
        // ===================单数组的=======
        if (triangle == null || triangle.size() == 0)
            return 0;
        int row = triangle.size();
        int col = triangle.get(row - 1).size(); // 找到行与列
        int[] dp = new int[row];
        dp[0]=triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        int pre = 0,temp;
        for(int i = 1;i<row;i++){
            List<Integer> list = triangle.get(i);
            for(int j =0;j<=i;j++){
                temp = dp[j];
                if(j==0){
                    dp[j]= temp+list.get(j);
                }else if(j==i){
                    dp[j] = pre+list.get(j);
                }else{
                    dp[j]= Math.min(pre,temp)+list.get(j);
                }
                pre = temp;//更新错了位置
            }
        }
        for (int i = 0; i < row; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;

    }
}
// @lc code=end
