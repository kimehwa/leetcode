import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 子串和子序列的问题，这个题考察的情况是？
         * 不含重复字符的最长子串的情况，先转化为字符数组？
         * 四个知识点，哈希表，两个指针，字符串，以及滑动窗口！！
         * 思路是什么呢？滑动窗口如何进行编程呢
         * aba和abca，就把左边的a移出去，这个题如何进行编程实现呢？
         * 滑动窗口的套路题
         */
        if (s.length()==0) {
            return 0;   
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){//如果哈希表中出现了charAt（i）就要找到上一个hashmap的位置
                left = Math.max(map.get(s.charAt(i))+1,left);//注意边界问题啊,为了防止向左移动
            }
            map.put(s.charAt(i), i);//这里一个字母的要用character
            max = Math.max(max, i-left+1);//这里比较要加一啊
        }
        return max;
        
    }
}
// @lc code=end

