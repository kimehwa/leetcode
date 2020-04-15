import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        // 我写一遍morris遍历,递归遍历好写，用stack试一下，写代码。今天尝试写出来代码
        // List<Integer> res = new ArrayList<>();
        // Stack<TreeNode> stack = new Stack<>();
        // TreeNode cur = root;
        // while (!stack.isEmpty() || cur != null) {
        //     while (cur != null) {
        //         stack.push(cur);
        //         cur = cur.left;
        //     }
        //     cur = stack.pop();
        //     res.add(cur.val);
        //     cur = cur.right;
        // }
        // return res;
        // =========morris遍历先写个序==========
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre;
        while(cur!=null){
            if(cur.left == null){
                res.add(cur.val);//在这里添加；
                cur=cur.right;
            }else{
                pre = cur.left;
                while(pre.right!=null){
                    pre = pre.right;//找到左子树的最右节点
                }
                pre.right = cur;  //连接到顶点上
                TreeNode temp = cur;
                cur =cur.left;
                temp.left = null; //避免出现循环，把树进行还原
            }
        }
        return res; //还是左程云那个好点
    }
}
// @lc code=end
