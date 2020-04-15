import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
   

    public boolean isValid(String s) {
        /**
         * 第一感觉是用stack来做的，或者用计数的方法 stack好像不太好使
         * 计数对单一的好使，所以用stack来做，跟我想的一样
         * 用hashmap进行处理
         */
        if(s==null||"".equals(s)) return true;
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> map =new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                stack.add(c);
            }else{
                if(stack.size()==0) return false;
                Character temp = stack.pop();
                if(map.get(c)!=temp) return false;
            }
        }
        return stack.isEmpty()?true:false;
    }
}
// @lc code=end

