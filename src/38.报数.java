/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        // 用循环找到前面的每一列相同的然后计数，用sb做
        if (n == 1)
            return "1";
        String str = "1";
        for (int i = 2; i <= n; i++) {
            //外层循环依次把每一个1，2，3.。全部找到
            StringBuilder sb = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre)
                    count++;
                else {
                    sb.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            sb.append(count).append(pre);
            str = sb.toString();
        }
        return str;
    }
}
// @lc code=end
