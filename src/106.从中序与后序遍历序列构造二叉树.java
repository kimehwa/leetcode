/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //中序遍历是左中右 后序遍历是左右中，果然后序遍历的最后一个节点就是跟节点
        // 有一个api是Arrays.copyOfRange(int[],first,last)
    }
}
// @lc code=end

