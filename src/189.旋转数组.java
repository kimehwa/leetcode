/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        //向右移动k个位置？要取余数
       //第一种方法直接发  ：用一个previous变量和tmp变量
       //第二种方法使用额外的数组：
       int[] a = new int[nums.length];
       for(int i = 0;i<nums.length;i++){
           a[(i+k)%nums.length]=nums[i];
       }
       for(int i = 0;i<nums.length;i++){
           nums[i]=a[i];
       }

    }
}
// @lc code=end

