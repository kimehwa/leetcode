import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // 这个题 超过一次的10个 感觉是滑动窗口，用hashmap存取吗，用bitmapping
        // 简单的方法
        // int len = s.length();
        // Set<String> res = new HashSet<>();// 结果集 相当于第二次的重复
        // Set<String> set = new HashSet<>();// 第一次的结果
        // for (int i = 0; i <= len - 10; i++) {
        //     String key = s.substring(i, i + 10);// 因为substring取不到所以
        //     if (set.contains(key)) {
        //         res.add(key);
        //     } else {
        //         set.add(key);
        //     }
        // }
        // return new ArrayList<>(res);
        // =========用bitmap进行简化========
        //正常情况下int是32位的  但是我们只需要低位20，所以我们可以用一个20位的低位与其相与
        int len = s.length();
        if(len==0||len<10){
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        char[] map = new char[26];
        map['A'-'A'] =0;
        map['C'-'A'] = 1;
        map['G'-'A'] =2;
        map['T'-'A']=3;
        int key = 0;
        char[] array = s.toCharArray();
        for(int i=0;i<10;i++){
            key=key<<2|map[array[i]-'A'];
        }
        set.add(key);
        for(int i =10;i<len;i++){
            key<<=2;
            key|=map[array[i]-'A'];
            key&=0xfffff;//16进制这么写
            if(set.contains(key)){
                res.add(s.substring(i-9,i+1));
            }else{
                set.add(key);
            }
        }
        return new ArrayList<>(res);
    }
}
// @lc code=end
