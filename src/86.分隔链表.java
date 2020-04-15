/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // 首先第一个问题 要不要用哑结点
        // 第二个问题 还要保留每个节点的初始位置，果然是双指针
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // ListNode first = dummy;
        // ListNode second = dummy;
        // while(second.next!=null&&second.next.next!=null){
        // if(second.next.val>=x){
        // second=second.next;
        // }else{
        // ListNode temp1 = second.next;
        // second.next =second.next.next;
        // ListNode temp2 = first.next;
        // first.next = temp1;
        // temp1 = temp2;
        // first =first.next;
        // }
        // }
        // return dummy.next;
        // 一个链表收集比x小的数字，一个收集比x大的数字
        ListNode min = new ListNode(0);
        ListNode minPoint = min;
        ListNode max = new ListNode(0);
        ListNode maxPoint = max;
        while (head != null) {
            if (head.val < x) {
                minPoint.next = head;// 吧这个指针放到下一位
                minPoint = head; // 小指针右移一位
            } else {
                maxPoint.next = head;
                maxPoint = head;
            }
            head = head.next;
        }
        // 遍历完之后进行拼接
        maxPoint.next = null;
        minPoint.next = max.next;

        return min.next;

    }
}
// @lc code=end
