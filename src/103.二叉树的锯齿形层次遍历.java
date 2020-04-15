import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

import sun.misc.Queue;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //这个题左神的书上有 用一个布尔变量表达 然后用一个双端队列吗，双端队列的使用方
        //法还是 不太能理解
        // List<List<Integer>> res = new ArrayList<>();
        // if(root==null) return res;
        // boolean reverse = false;
        // int level=0;
        // Queue<TreeNode> queue = new LinkedList<>();//一个双端队列吗
        // queue.addFirst(root);
        // while(!queue.isEmpty()){
        //     res.add(new ArrayList<>());
        //     int level_length = queue.size();
        //     if(!reverse){
        //         TreeNode node = queue.removeFirst();
        //         res.get(level).add(node.val);
        //         if()
        //然后在二者中更新即可
        helper(root,0);
        return ans;

    }
    public void insert(TreeNode node,int level){
        List<Integer> list = level>=ans.size()?null:ans.get(level);
        if(list==null){
            list = new LinkedList<>();
            list.add(node.val);
            ans.add(list);
        }else{
            boolean isOld = (level&1)==1;//判断是否为奇数 因为层数从第0层开始
            list.add(isOld?0:list.size(),node.val);//用这个add的两个层
        }
    }
    public void helper(TreeNode root,int level){
        if(root==null) return ;
        insert(root, level);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}
// @lc code=end

