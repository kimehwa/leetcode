/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // 常数时间下进行排序。插入排序是n2的时间复杂度 果然是归并排序
        // 归并排序是用的分治思想 递归法的归并排序
        // 归并排的方法不能使用递归 因为递归的时间复杂度n和递归函数调用，但是链表可以通过修改来
        // 更改节点顺序，无需向链表一样开辟空间
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } // 找到了中间节点或者中间节点左边的一个值 分奇数偶数

        ListNode tmp = slow.next;
        slow.next = null;// 切断链表
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);// 现在左边和右边的分别有序了
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;// 用一个中间变量进行保存
        }
        h.next = left != null ? left : right;
        return res.next;  //其实归并排序的思路很好想，先处理中间在处理左边

    }
}
// @lc code=end
