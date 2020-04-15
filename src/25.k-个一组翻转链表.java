/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 还是要用几个dummy节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 先设计了两个变量
        ListNode pre = dummy; // 表示反转前一个节点
        ListNode end = dummy; // 反转后面的最后一个节点
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++)
                end = end.next; // 先找到end 节点，因为从dummy开始，找到的是反转的最后一个节点

            if (end == null)
                break;
            ListNode start = pre.next;
            ListNode next = end.next;// 反转节点将要反转的下一个节点
            end.next = null; // 把节点先断开
            pre.next = reverse(start); // 把前面正确的连接
            start.next = next;// 此时start节点已经是反转的最后一个了 连接上去
            pre = start;
            end = pre;// 重新更新这两个的位置；
        }
        return dummy.next;

    }

    public ListNode reverse(ListNode head) {
        // 反转单链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end
