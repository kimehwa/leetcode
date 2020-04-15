import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // 前序遍历是中左右,每个节点从中间节点，中间节点在前面的叫前序遍历
        // if (root == null)
        //     return res;
        // res.add(root.val);
        // preorderTraversal(root.left);
        // preorderTraversal(root.right);
        // return res;
        // =================迭代法，用一个stack来处理深度，还可以用morris遍历
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        // while(!stack.isEmpty()&&root!=null){
        //     TreeNode cur = stack.pop();
        //     res.add(cur.val);
        //     if(cur.right!=null){
        //         stack.push(cur.right);
        //     }
        //     if(cur.left!=null){
        //         stack.push(cur.left);
        //     }
        // }
        // return res;
        // ===================方法3：morris遍历。morris遍历的步骤，morris我弄了几百遍了
        // TreeNode cur = root;
        // while(cur!=null){
        //     if(cur.left!=null){
        //         TreeNode mostLeft = cur.left;
        //         while(mostleft.right!=null&&mostleft.right!=cur){
        //             mostLeft=mostLeft.right;
        //         }
        //         mostLeft.right=cur;
        //         cur=cur.left;
        //         if(mostLeft.right==cur){
        //             mostLeft.right=null;
        //         }
        //     }else{
        //         cur=cur.right;

        //     }
            if(root==null) return res;
            TreeNode cur = root;
            TreeNode mostRight = null;
            while(cur!=null){
                mostRight = cur.left;
                if(mostRight!=null){//如果当前cur有左子树
                    while(mostRight.right!=null&&mostRight.right!=cur){
                        mostRight=mostRight.right;
                    }
                    if(mostRight.right==null){
                        mostRight.right = cur;
                        res.add(cur.val);//cur只能到达一次的节点，无左子树cur到达直接打印
                        cur=cur.left;
                        continue;
                    }else{
                        mostRight.right = null;
                    }
                }else{
                    res.add(cur.val);//第一次打印cur能到达两次的节点
                }
                cur=cur.right;//没有左子树直接右移
            }
        
            return res;
        

    }
}
// @lc code=end
