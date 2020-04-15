/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        // 可能存在重复的元素
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right = right - 1;//每次把right向右移动一格
            }
        }
        return nums[left];
        // if(nums==null||nums.length==0) return -1;
        // int len =nums.length-1;
        // if(nums[len]>nums[0]) return nums[0];
        // int  from = 0,to= len;
        // while(from<to){
        //     if(nums[from]<nums[to]){
        //         return nums[from];
        //     }
        //     int mid = (from+to)>>>2;
        //     int num = nums[mid];
        //     if(num>nums[mid]){ 
        //         from = mid+1;
        //     }else if
        // }
    }
}
// @lc code=end
