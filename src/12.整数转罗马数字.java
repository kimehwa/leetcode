/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        // 贪心算法
        int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        // 每次用最少的配最大的
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < 13) {// 3999之内的
            while (num >= nums[index]) {
                sb.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return sb.toString();
    }
}
// @lc code=end
