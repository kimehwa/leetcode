import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();// 从底到顶为增的找到最小值 反之为最大值，找到的是peek的那个地方的极值
        stack.push(-1);// 还要考虑单调栈为空的情况 所以先预设了一个-1进去
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1&&heights[i] <= heights[stack.peek()] ) {// 判断是否到达了左边界，因为先判断是否-1；啊啊啊 
                
                //为啥我把第一个条件写后面就不行呢？
                int temp = stack.pop();
                max = Math.max(max, (i - stack.peek() - 1) * heights[temp]);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) { //到达了右边界了  但是栈还没空
            max= Math.max(max, heights[stack.pop()]*(heights.length-stack.peek()-1));
        }
        return max;

    }
}
// @lc code=end
