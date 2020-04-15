/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        //我这种写法为啥不对
        // int left=0,right = nums.length-1;
        // while(left<right){
        //     if(nums[left]==nums[left+1]){
        //         swap(nums, left, --right);
        //     }else{
        //         left++;
        //     }
        // }
        // return left;
        //用两个指针，一个快指针一个慢指针
        if(nums.length==0) return 0;
        int i = 0;
        for(int j = 1;j<nums.length;j++){
            if(nums[i]!=nums[j]){//如果相等就跳j
                i++;
                nums[i]=nums[j];//把nums[j]的值复制到nums[i+!]的位置上
            }
        }
        return i+1;
    }
    // public void swap(int[] nums,int i,int j){
    //     int temp = nums[i];
    //     nums[i]=nums[j];
    //     nums[j]=temp;
    // }
}
// @lc code=end

