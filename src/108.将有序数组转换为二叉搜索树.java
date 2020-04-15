/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0, nums.length-1);

    }
    public TreeNode helper(int[] nums,int left,int right){
        if(left>right) return null;
        int p = (left+right)>>>1;
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(nums,left, p-1);
        root.right = helper(nums,p+1, right);
        return root;
    }
}
// @lc code=end

