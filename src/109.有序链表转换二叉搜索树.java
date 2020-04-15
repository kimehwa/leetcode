/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode mid = findMidElement(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid)
            return node;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    public ListNode findMidElement(ListNode head) {
        ListNode pre = null;// 需要用一个指针保存slow的前一个节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {// 这里的是与的关系并且是fast与fast。next，不能用两个
            //不能用两个next节点否则会丢失2个长度的信息
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre != null) {
            pre.next = null;// 从pre节点开始切开
        }
        return slow;// 中间的节点
    }
}
// @lc code=end
