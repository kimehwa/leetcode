/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 对称二叉树，左子树等于其右子树,这个需要个帮助函数吗
        // 自己写的总是没有别人好啊 。不过毕竟自己写出来了。
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null)
            return false;
        if (root1.val == root2.val && helper(root1.left, root2.right) && helper(root1.right, root2.left)) {
            return true;
        }
        return false;
    }
}
// @lc code=end
