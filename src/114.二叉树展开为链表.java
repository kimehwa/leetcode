/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        // while (root != null) {
        //     if (root.left == null) {
        //         root = root.right; // 向右移动
        //     } else {
        //         TreeNode pre = root.left;// 找到子树最右边的节点
        //         while (pre.right != null) {
        //             pre = pre.right;
        //         }
        //         pre.right = root.right;
        //         root.right = root.left;
        //         root.left = null;
        //         // 考虑下一个节点
        //         root = root.right; // 记住中序遍历是左跟右 根在中间，先序遍历是根在前面
        //     }

        // }
        if(root ==null){
            return ;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left =null;
        pre = root;


    }
}
// @lc code=end
