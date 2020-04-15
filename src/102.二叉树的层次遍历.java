import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        // List<List<Integer>> res = new ArrayList<>();
        // if (root == null)
        //     return res;
        // Queue<TreeNode> queue = new LinkedList<>();

        // queue.add(root);// 这届add就行
        // int level = 0;// 设置层数。
        // while (!queue.isEmpty()) {
        //     res.add(new ArrayList<>());
        //     int levels_length = queue.size();//这里是队列的长度
        //     for (int i = 0; i < levels_length; ++i) {
        //         TreeNode node = queue.remove();
        //         res.get(level).add(node.val);// 这里进行填充
        //         if (node.left != null)
        //             queue.add(node.left);
        //         if (node.right != null)
        //             queue.add(node.right);
        //     }
        //     level++;// j进行下一层的处理

        // }
        // return res;
        if(root==null){
            return res;
        }
        helper(root, 0);
        return res;

    }
    public void helper(TreeNode root,int index){
        if(res.size()==index){
            res.add(new ArrayList<>());
        }
        res.get(index).add(root.val);//递归主要是这个部分要写上去
        if(root.left!=null){
            helper(root.left, index+1);
        }
        if(root.right!=null){
            helper(root.right, index+1);
        }

    }
}
// @lc code=end
