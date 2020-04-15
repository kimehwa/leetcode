import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    //这个题除了bt，还要判断字符串是否是回文字符串
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        // Stack<String> stack = new Stack<>();官方文档建议写为deque
        Deque<String> stack = new ArrayDeque<>();
        if(s==null) return res;
        dfs(s, 0, stack);
        return res;
    }
    public void dfs(String s,int start,Deque<String> stack){
        // char[] c = s.toCharArray();
        if(start==s.length()){
            res.add(new ArrayList<>(stack));
            return ;
        }
        for(int i = start;i<s.length();i++){
            //截取字符串小号性能，采用传子串索引的方式判断一个子串是否是回文串
            // String ids = s.substring(start, i);
            // if(isRotateString(ids)){
            //     stack.push(ids);
            //     dfs(s, i, stack);
            // }
            // stack.pop();
            if(!isRotateString(s, start, i)){
                continue;//如果不是子串的话 直接剪支
            }
            stack.addLast(s.substring(start, i+1));
            dfs(s,i+1,stack);
            stack.removeLast();

        }

    }
    private boolean isRotateString(String str,int left,int right){
        
        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    //回文子串的状态转移方程是当stri==strj的时候，看i+1~j-1是否是回文子串还要判断right-left是否大于2
    //然后做一个二维的布尔数组，把所有可能的子序列的情况全部整理出来
}
// @lc code=end

