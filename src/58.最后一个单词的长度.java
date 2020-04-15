/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;// 找到最后一个字符串
        // 这个以要防止最后还有空格
        while (end >= 0 && s.charAt(end) == ' ')
            end--;
        if (end < 0)
            return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ')
            start--;
        return end - start;

    }
}
// @lc code=end
