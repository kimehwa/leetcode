/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        //这个题的关键是要注意到Character的一些方法，今天看用Ixia
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            idx++;// 去掉前导空格
        }
        if (idx == n) {
            return 0; // 如果空格一直到末尾
        }
        boolean negative = false; // 判断正负最好是用一个布尔值
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            return 0; // 如果遇到了其他符号
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;

    }
}
// @lc code=end
