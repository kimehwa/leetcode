/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        // if (root == null)
        //     return null;
        // Node pre = root;
        // while (pre.left != null) {
        //     // 把tmp的左右节点连接起来？
        //     Node tmp = pre;
        //     while (tmp != null) {
        //         tmp.left.next = tmp.right; // 外层循环已经判断了当前节点的left不为空
        //         if (tmp.next != null) {//下一个不为空说明上一层已经帮我们完成串联了
        //             tmp.right.next = tmp.next.left; // 跨越两层的处理

        //         }
        //         tmp = tmp.next;
        //     }
        //     pre = pre.left;// 从下一层的最左边开始遍历
        // }
        // return root;
        // ======================方法2 递归的方法===============
        dfs(root);
        return root;

    }
    public void dfs(Node root){
        if(root == null) return ;
        Node left = root.left;
        Node right = root.right;
        while(left!=null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
// @lc code=end
