/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        // 二分法 无论怎么分，首元素大于尾元素
        int l = 0,r = nums.length-1;
        while(l<r){
            int mid = (l+r)>>>1;
            if(nums[r]<nums[mid]){
                l=mid+1;
            }else{
                r= mid;
            }
        }
        return nums[l];

    }
}
// @lc code=end

