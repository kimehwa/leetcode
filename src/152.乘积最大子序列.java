/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        //果然是dp,这个题因为负数的存在还要找到最小值
        // int n = nums.length;
        // if(n==1){
        //     return nums[0];
        // }
        // int[] dp = new int[n];
        // dp[0] = nums[0];
        // int max = nums[0];
        // for(int i = 1;i<n;i++){
        //     dp[i]= Math.max(dp[i], dp[i-1]*nums[i]);
        //     max = Math.max(max, dp[i]);
        // }
        // return max;
        // ================================
        int max = Integer.MIN_VALUE,imax = 1,imin=1;
        for(int i=0;i<nums.length;i++){
            //一个最大一个最小子序列，因为遇到负号的时候 最大的乘以负数就变成最小的了
            //所以二者要交换位置
            if(nums[i]<0){
                int tmp = imax;
                imax = imin;
                imin = tmp; //如果小于0 二者更换位置
            }
            imax = Math.max(imax*nums[i],nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            max = Math.max(imax,max);
        }
        return max;
    }
}
// @lc code=end

