/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 这个比较简单，从左下或者右上搜.怎么写代码呢？ 网上的思路和我的一样啊
        // if (matrix == null || matrix.length == 0)
        //     return false;
        // int r = matrix.length, c = matrix[0].length;
        // int i = r - 1, j = 0;
        // while (i >= 0 && j < c) {
        //     if (matrix[i][j] == target) {
        //         return true;
        //     } else if (matrix[i][j] > target) {
        //         i--;//这里搞错了
        //     } else {
        //         j++;
        //     }
        // }
        // return false;
        // 二分法进行判断============方法2 ======  可以看做一个二分查找的模板 思路是把一个二维数组展平,二分法的思路要快一些
        if (matrix == null || matrix.length == 0)
            return false;
        int l = 0,r=matrix.length*matrix[0].length-1;
        while(l<=r){
            int mid = (l+r)>>>1;
            int i = mid/matrix[0].length;
            int j =mid%matrix[0].length;
            if(matrix[i][j]==target){
                return true;
            }else if(matrix[i][j]>target){
                r=mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;



    }
}
// @lc code=end
