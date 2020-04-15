/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    // 用record记录行与列
    public int totalNQueens(int n) {
        if (n < 0)
            return 0;
        int[] record = new int[n];
        return dfs(0, record, n);

    }

    public int dfs(int i,int[] record,int n){
        if(i==n) return 1;
        int res = 0;
        for(int j=0;j<n;j++){
            if(isValid(record, i, j)){
                record[i]=j; //这里首先要先记录一下啊
                res+=dfs(i+1, record, n);
            }
        }
        return res;
    }

    public boolean isValid(int[] record, int i, int j) {
        // 判断是否有效的步骤，先看行列，在看对角线。
        for (int k = 0; k < i; k++) {
            // 看是否列相等,在看每一个的k-i，是否与rocord【k】-j相等，如果满足|a-i|==|b-j|即可判断
            if (j == record[k] || Math.abs(i - k) == Math.abs(record[k] - j)) {
                return false;
            }
        }
        return true;

    }
}
// @lc code=end
