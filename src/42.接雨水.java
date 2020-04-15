import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // 单调栈的解法，每一个的高度为其中的最近左边最高和右边最高的差值，记得栈内是存储的下标的位置
        int sum = 0;
        Stack<Integer> stack = new Stack<>();// 让stack严格递减从栈顶到栈底
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];// 先保存下来这个元素
                stack.pop();
                if (stack.isEmpty())
                    break;
                // current为右边的最大值，栈顶为左边的最大值
                int distance = current - stack.peek() - 1; // 两堵墙之间的距离
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);// 这个相当于按层进行添加的啊。好好记住这里
            }
            stack.push(current);
            current++;
        }
        return sum;
    }
}
// @lc code=end
