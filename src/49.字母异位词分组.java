import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 这个题应该怎么写？怎么用hash表呢？一个hash表维护了一个str与一个list

        if (strs == null)
            return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>(); // 排列一下就行了
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);// 这一步太关键了
            String key = String.valueOf(c);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());// 获取map中所有值的集合。注意这个api

    }
}
// @lc code=end
