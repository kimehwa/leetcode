/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        //出现了三次？上一个题用异或。这个要用到很多二进制的一些用法
        //统计所有数字中每个位中1出现的总数，对于某个数，1出现的次数一定是3的倍数+1或者0，那么对这个数%3的到的结果就是
        //母的数字在该位上的值
        int res = 0;
        for(int i = 0;i<32;i++){
            int  sum =0;
            for(int j = 0;j<nums.length;j++){
                sum+=(nums[j]>>i)&1;
            }
            res ^=(sum%3)<<i;
        }

        return res;
    }
}
// @lc code=end

