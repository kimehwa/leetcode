import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        /**
         * 这种题就是考察各种转换的情况，把其中的放入hash表中
         */
        HashMap<String,Integer> map = new HashMap<>();//把所有的情况放入一个hash表中
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC",90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int res = 0;
        for(int i=0;i<s.length();){//这里的for循环还可以这么写
            if(i+1<s.length()&&map.containsKey(s.substring(i, i+2))){//substring取不到后面的
                res+=map.get(s.substring(i,i+2));
                i=i+2;
            }else{
                res+=map.get(s.substring(i,i+1));
                i+=1;
            }

        }
        return res;
        
    }
}
// @lc code=end

