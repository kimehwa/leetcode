import java.util.Stack;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        // 逆波兰表达式的使用,还可以用数组代替栈，两者的原理是一样的
        Stack<Integer> stack = new Stack<>();
        Integer op1, op2;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case "-":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 - op1);
                    break;
                case "*":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 * op1);
                    break;
                case "/":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 / op1);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }
}
// @lc code=end
