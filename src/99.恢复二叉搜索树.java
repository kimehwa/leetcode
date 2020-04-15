/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        // 竟然自然而然的想起了通过前后序列的数组来恢复一棵树，用递归进行处理
        // 先用中序遍历进行处理，然后找到两个元素，并不是给数组而是给了一棵树 用中序的morris遍历即可
        if (root == null) {
            return;
        }
        TreeNode node1 = null;
        TreeNode node2 = null;
        TreeNode mostRight = null;
        TreeNode cur = root;
        TreeNode pre = null;//开始是null啊
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {//这里需要注意一下啊 找到其最右节点
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) { //如果发现为空了最右节点的右子树 
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;// 第二次遍历到了 需要把其节点恢复
                }
            }
            // 中序遍历需要在这个地方进行处理
            if (pre != null && pre.val > cur.val) {// 正常都是右边大于左边，找到了两边的两个节点
                // 找到了需要交换的两个节点了
                node1 = node1 == null ? pre : node1;
                node2 = cur;
            }
            pre = cur; // 这里加上去是啥意思，每一个pre都在cur的前一个位置啊。。。
            cur = cur.right;
        }
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp; // 交换 只需要改变val值即可 这有点尴尬

    }
}
// @lc code=end
