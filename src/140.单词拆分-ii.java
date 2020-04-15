import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {
    HashMap<Integer,List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        // 动态规划与回溯，解决此题最简单的方法是使用回溯法，为了找到解
        // 把所有的字符串的可能前缀是否在字典中，如果在检查回溯函数并检查剩余部分
        // 如果剩余部分可以形成有效拆分，这个函数返回前缀s1，并将回溯调用的剩余结果
        // 跟在s1的后面，否则返回空  
        //可以改为记忆化回溯
        return word_break(s, wordDict, 0);
    }

    // public List<String> word_break(String s, List<String> wordDict, int start) {
    //     LinkedList<String> res = new LinkedList<>();
    //     if (start == s.length())
    //         res.add("");
    //     for (int end = start + 1; end <= s.length(); end++) {//因为分割的时候取不到end
    //         if (wordDict.contains(s.substring(start, end))) {
    //             List<String> lists = word_break(s, wordDict, end);
    //             for (String list : lists) {// 这个回溯法 好好理解啊
    //                 res.add(s.substring(start, end) + (list.equals("") ? "" : " ") + list);
    //             }
    //         }
    //     }
    //     return res;
    // }
    //记忆化回溯的方法，把中间状态保存,key是当前字符串的开始下标，value包含了所有从头开始的可行句子，下次遇到相同位置的时候，可以从
    //hashmap直接取出
    public List<String> word_break(String s,List<String> wordDict,int start){
        if(map.containsKey(start)) return map.get(start);
        LinkedList<String> res = new LinkedList<>();
        if(start==s.length()) res.add("");
        for(int end = start+1;end<=s.length();end++){
            if(wordDict.contains(s.substring(start,end))){
                List<String> list = word_break(s, wordDict, end);
                for(String l:list){
                    res.add(s.substring(start,end)+(l.equals("")?"":" ")+l);
                }
            }
        }
        map.put(start,res);
        return res;
    }
}
// @lc code=end
