/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        // 又是一个移除双指针的问题
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // 如果j与val相等，让j进行移动,若果不等的话让nums[i]=nums[j]
            if (val != nums[j]) {
                nums[i] = nums[j];// 这里会对其复制
                i++;
            }
        }
        return i;
    }
}
// @lc code=end
