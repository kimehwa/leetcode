/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        //这个题以前做过？应该是那个选举法
        int idx = nums[0];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==idx){
                count++;
            }else{
                count--;
                if(count==0){
                    idx=nums[i+1];
                }
            }
        }
        return idx;
    }
}
// @lc code=end

