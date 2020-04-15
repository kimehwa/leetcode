/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        // 补0 直接append进行即可，加了可能会 出现carry位
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String res = "0";// 保存计算结果
        // 让num2与num1逐位相乘，而且是从后往前乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;// 进位
            // 保存num2第i位与nums1相乘的结果
            StringBuilder temp = new StringBuilder();// 每一次循环都生成了一个sb
            // 补0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';// 从后往前的每一位
            // num2的第i位数字与num1相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';//脑残吧我草
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);// 这样计算append是个反的
                carry = (n1 * n2 + carry) / 10;
            }
            res = addString(res, temp.reverse().toString());

        }
        return res;
    }

    public String addString(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            sb.append(sum);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end
