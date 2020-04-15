/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        // 这个题的初始思路是二分法？与之前那个题有点像
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] > nums[i + 1]) {
        //         return i;
        //     }
        // }
        // return nums.length - 1;
        // ==========方法2 递归二分法的思路  通过nums[mid]与nums[i]的关系来判断？升序还是降序
            return helper(nums, 0, nums.length-1);//二分法写的对 但是传参传错了、

    }
    public int helper(int[] nums,int l,int r){//递归的二分查找
        
        while(l<r){//右半部分取不到
            int mid = (l+r)>>>1;
            if(nums[mid]>nums[mid+1]){
                r = mid;
            }else{
                l= mid+1;
            }
        }
        return l;
    }
}
// @lc code=end
