/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        // sum = 0;
        if (root != null) {
            helper(root, 0);
        }
        return sum;
    }

    public void helper(TreeNode node, int current) {
        if (node.left == null && node.right == null) {
            sum += current * 10 + node.val;
            return;
        }
        if (node.left != null) {
            helper(node.left, 10 * current + node.val);
        }
        if (node.right != null) {
            helper(node.right, 10 * current + node.val);
        }
    }
}
// @lc code=end
