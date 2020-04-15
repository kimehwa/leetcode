import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;//这个条件不能忘记啊
        if(p.val==q.val){
            if(isSameTree(p.left, q.left)&&isSameTree(p.right, q.right)){
                return true;
            } //我这样写效率不高啊，因为处理了很多次这个，不过整体来说这种简单的递归树还是能写出来一点了
        }
        return false;
        // if(q.val!=p.val) return false;
        // return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
    }
}
// @lc code=end

