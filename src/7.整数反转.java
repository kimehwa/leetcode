/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        /**
         * 整数反转的问题 思路 这种反转问题用stack刚好啊，每一步用余数余10， 还要注意溢出问题，怎么写代码呢？java的stack怎么使用呢？都忘得差不多了
         * 用数学方法的取余数与除法
         */
        int rev = 0;// 构建的第一个数字，跟求和累加是一样的
        while (x != 0) {
            int pop = x % 10;// 得到其最后一位
            x /= 10;
            // 判断溢出的情况
            if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && pop > 7) {
                return 0;// 这种int的返回值一般不为null为0
            }
            if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && pop < -8) {
                return 0;
            }
            rev = rev * 10 + pop;// 依次更新从小到大的值

        }
        return rev;
    }
}
// @lc code=end
