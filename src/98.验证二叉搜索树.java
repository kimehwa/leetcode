import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // return helper(root, null, null);
        //方法2：还可以用中序遍历来完成
        Stack<TreeNode> stack = new Stack<>();
        double inorder = -Double.MAX_VALUE;//这个为啥要这么设置
        while(!stack.isEmpty()||root!=null){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(root.val<=inorder) return false;
            inorder = root.val;//更新inorder的顺序；
            root=root.right;
        }
        return true;

    }

    // 用一个帮助函数，遍历的时候保存上界和下界
    public boolean helper(TreeNode node, Integer lower, Integer higher) {
        if (node == null)
            return true;
        int val = node.val;
        if (lower != null && lower >= val)
            return false;
        if (higher != null && higher <= val)
            return false;
        if (!helper(node.right, val, higher))
            return false;
        if (!helper(node.left, lower, val))
            return false;
        return true;
    }
}
// @lc code=end
