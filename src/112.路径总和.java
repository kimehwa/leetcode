/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        // if(sum==0) return true;
        // if(sum<0){
        //     return false;
        // }
        // return hasPathSum(root.left, sum-root.val)||hasPathSum(root.right, sum-root.val);
        //注意递归的写法
        sum-=root.val;
        if(root.left==null&&root.right==null){//递归到达尽头了 判断一下
            return sum==0;
        }
        return hasPathSum(root.left, sum)||hasPathSum(root.right, sum);
    }
}
// @lc code=end

