/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 这个题应该怎么处理呢？
        ListNode dummy = new ListNode(0);// 为了防止删除头结点的特殊情况
        dummy.next = head;

        ListNode cur = dummy;// 只用一个就弄好了的
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {// 相等的情况
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;// 这里在删除重复的节点
                }
                cur.next = temp.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end
