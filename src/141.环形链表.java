/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //判断链表中是否有环，应该用一个快慢指针
        //边界条件
        if(head ==null||head.next==null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(true){ //我错的地方知道了 有环的话
            if(fast==null||fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) break;
        }
        return true;
        // return false;
        // ListNode slow = head;
        // ListNode fast = head.next; //这两个不是在一个点的
        // while(slow!=fast){
        //     if(fast==null||fast.next==null){
        //         return false;
        //     }
        //     fast = fast.next.next;
        //     slow = slow.next;
        // }
        // return true;
    }
}
// @lc code=end

