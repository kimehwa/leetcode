import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return res;
        Stack<Integer> stack = new Stack<>();
        dfs(root, sum, stack);
        return res;

    }

    public void dfs(TreeNode root, int sum, Stack<Integer> stack) {
        // 这个是叶子节点
        if (root == null)
            return;
        sum -= root.val;
        stack.push(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(stack));

        } else {
            dfs(root.left, sum, stack);
            dfs(root.right, sum, stack);

        }

        stack.pop();

    }
}
// @lc code=end
