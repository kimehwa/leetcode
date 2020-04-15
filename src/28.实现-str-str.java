import javax.naming.spi.DirStateFactory.Result;

/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        // 用kmp做？还可以用双指针做 sunday算法做
        int res = -1;
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        if (needleChar.length == 0)
            return 0;
        for (int i = 0; i < haystackChar.length; i++) {
            if (haystackChar[i] == needleChar[0]) {
                if (i + needleChar.length > haystackChar.length)
                    continue;
                for (int j = 0; j < needleChar.length; j++) {
                    res = i;
                    if (haystackChar[i + j] != needleChar[j]) {
                        res = -1;
                        break;
                    }
                }
                if (res > -1) {
                    return res;
                }
            }
        }
        return res;

    }
}
// @lc code=end
