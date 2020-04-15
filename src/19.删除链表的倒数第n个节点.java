import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //使用哑结点来进行完成一些特殊情况的判断
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // int len = 0;
        // ListNode first = head;
        // while(first!=null){
        //     len++;
        //     first = first.next;
        // }
        // len -= n;
        // first =dummy;
        // while(len>0){
        //     len--;
        //     first=first.next;
        // }
        // first.next = first.next.next;
        // return dummy.next;
        // ============双指针完成一次遍历完成===============先一个指针走n步 然后再完成两个指针一起走
        ListNode dummy = new ListNode(0);
        dummy.next= head;  //用压指针完成
        ListNode first = dummy;
        ListNode last =  dummy;//刚开始写的head
        int len = n;
        while(len>0){
            len--;
            first = first.next;
        }
        while(first.next!=null){
            last=last.next;
            first = first.next;
        }
        last.next = last.next.next;
        return dummy.next;
        
    }
}
// @lc code=end

