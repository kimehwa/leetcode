/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //可以用递归也可以用迭代
        // if(l1==null){
        //     return l2;
        // }else if(l2==null){
        //     return l1;
        // }else if(l1.val<l2.val){
        //     l1.next = mergeTwoLists(l1.next, l2);
        //     return l1;
        // }else{
        //     l2.next = mergeTwoLists(l1, l2.next);
        //     return l2;
        // }
        // 迭代的方法思路来进行设计========
        ListNode prehead = new ListNode(0);
        ListNode prev = prehead;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                prev.next = l1;
                l1=l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;//这个也进一步
        }
        prev.next = l1==null?l2:l1;
        return prehead.next;
        
    }
}
// @lc code=end

