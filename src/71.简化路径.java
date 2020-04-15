import java.util.Stack;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        // Stack<Character> stack = new Stack<>();
        // char[] pathch = path.toCharArray();
        // stack.push(pathch[0]);
        // for(int i =1;i<pathch.length;i++){
        //     if(pathch[i]=='/'&&pathch[i]==stack.peek()){    
        //         continue;
        //     }else if(pathch[i]=='.'&&pathch[i+1]=='.'&&stack.peek()=='/'){
        //         stack.pop();
        //     }
        // }
        //你妈卖批 用split切割
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<s.length;i++){
            if(!stack.isEmpty()&&s[i].equals("..")){
                stack.pop();
            }else if(!s[i].equals("")&&!s[i].equals(".")&&!s[i].equals("..")){
                stack.push(s[i]);  //其他情况不动就可以了
            }
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<stack.size();i++){
            // sb.append("/"+stack.get(i)); //stack 竟然还有get，我以为只有push与pop与size，这里可以改一下
            sb.append("/");
            sb.append(stack.get(i)); //这里减少了加的拼接 会好多
        }
        return sb.toString(); //stack继承了vector ，vector继承了List List里面的方法都能用
        //另外java8还有流的使用

    }
}
// @lc code=end

