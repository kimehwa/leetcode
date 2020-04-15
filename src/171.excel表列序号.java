/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        //相当于一个26进制的游戏？
        int ans = 0;
        for(int i=0;i<s.length();i++){
            int num = s.charAt(i)-'A'+1;
            ans = ans*26+num;
        }
        return ans;
        

    }
}
// @lc code=end

