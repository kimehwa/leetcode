/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 大致思路是找到preorder的第一个为跟节点，然后找到中序的节点，然后分为左右两部分
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    // p_end 在数组的末尾的下一个数字上
    public TreeNode helper(int[] preorder, int startp, int endp, int[] inorder, int starti, int endi) {
        if (startp == endp) {// preorder为空 直接返回
            return null;
        }
        TreeNode root = new TreeNode(preorder[startp]);
        // 找到中序遍历的节点
        int index = 0;
        /**
         * 这里可以进行优化，用hashmap吧这里的进行存储起来，先把inorder的每一个值与键存储起来，然后在这里直接看preorder的值有没有
         * 它即可。get()能得到i
         */
        for (int i = starti; i < endi; i++) {// 一定要注意这里是动态变化的 找inorder数组的啊
            if (preorder[startp] == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftNum = index - starti;
        // 根据inorder左边数字的数量进行处理leftNum+1;
        root.left = helper(preorder, startp + 1, startp + leftNum + 1, inorder, starti, index);
        root.right = helper(preorder, leftNum + 1 + startp, endp, inorder, index + 1, endi);
        return root;

    }
}
// @lc code=end
