import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        // 不同的二叉搜索树 这个根据那个卡特兰数能找到多少种，这个要遍历出来，这个还是要dp处理啊
        // 这个题跟回溯法差不多啊 ，多、写一下这个的递归问题
        if (n == 0) {
            return new LinkedList<>();
        }
        return generate_trees(1, n);

    }

    public LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> alltrees = new LinkedList<>();
        if (start > end) {
            alltrees.add(null);
            return alltrees;
        }
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> lefttrees = generate_trees(start, i - 1);// 递归的进行左右子树的递归
            LinkedList<TreeNode> righttrees = generate_trees(i + 1, end);
            for (TreeNode l : lefttrees) {
                for (TreeNode r : righttrees) {
                    TreeNode currentTrees = new TreeNode(i);// 以这个为子节点
                    currentTrees.left = l;
                    currentTrees.right = r;
                    alltrees.add(currentTrees);
                }
            }
        }
        return alltrees;
    }
}
// @lc code=end
