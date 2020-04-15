import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // 关键这个思路，尝试写一下试试
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0)
            return res;
        int wordLen = words[0].length();
        // hashmap1存各种单词
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        // 如何遍历所有子串
        for (int i = 0; i < s.length() - wordLen * wordNum + 1; i++) {
            HashMap<String, Integer> hasWords = new HashMap<>();// 存当前扫描的字符串含有的单词
            int num = 0;
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);//这个地方要用好啊
                    hasWords.put(word, value + 1);
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;

    }
}
// @lc code=end
