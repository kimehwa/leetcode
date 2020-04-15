/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    int maxSum= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //这个题左神的书上肯定有写，最大路径和出现在左边，最大路径和出现在右边，最大路径和坐标加中间加右边这三种情况
        //要定义一个信息类？returnTpye,这个不用
        findMaxPathSum(root);
        return maxSum;
    }
    public int findMaxPathSum(TreeNode root){
        if(root==null){
            return 0; //避免溢出？
        }
        //最大值是负数，可以选择不选
        int leftMax = Math.max(findMaxPathSum(root.left), 0);
        int rightMax = Math.max(findMaxPathSum(root.right), 0);
        int midMax = root.val+leftMax+rightMax;//这里来更新max值
        maxSum = Math.max(midMax, maxSum);
        return root.val+Math.max(leftMax, rightMax);//返回较大的一个是因为我们不能同时选择两条路啊
    }
}
// @lc code=end

