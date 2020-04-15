import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator {
    //这个题用一个什么结构进行处理。二叉搜索树是按照递增进行

    // List<Integer> list;
    // int index;
    // public BSTIterator(TreeNode root) {
    //     this.index = -1;  //索引从-1开始
    //     this.list = new ArrayList<>();
    //     this._inorder(root);
    // }
    
    // /** @return the next smallest number */
    // public int next() {
    //     return this.list.get(++this.index);
    // }
    
    // /** @return whether we have a next smallest number */
    // public boolean hasNext() {
    //     return this.index+1<this.list.size();
    // }
    // public void _inorder(TreeNode root){
    //     if(root==null){
    //         return ;
    //     }
    //     this._inorder(root.left);
    //     this.list.add(root.val);
    //     this._inorder(root.right);
    // }
    private final Deque<TreeNode> queue = new ArrayDeque<>();
    public BSTIterator(TreeNode node){
        while(node!=null){
            queue.addLast(node);
            node = node.left;
        }
    }
    public int next(){
        TreeNode cur = queue.pollLast();//这是最小的元素
        TreeNode node = cur.right;
        while(node!=null){
            queue.addLast(node);
            node = node.left;
        }
        return cur.val;
    }
    public boolean hasNext(){
        return !queue.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

