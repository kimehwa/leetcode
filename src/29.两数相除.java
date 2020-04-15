/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        // 这个题啥思路 用位移法
        if (dividend == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative; // 判断符号<
        negative = (dividend ^ divisor) < 0;// 用异或来判断符号是否相异,香异说明是负数
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if (t >> i >= d) {// 找出足够大的数2^n*divisor,t右移i位相当于成了2^n
                res += 1 << i; // 把结果加上2^n
                t -= d << i;// 把被除数减去2^n*divsior
            }
        }

        return negative ? -res : res;
    }
}
// @lc code=end
