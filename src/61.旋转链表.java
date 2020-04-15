/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 链表每个节点向右移动k个位置，这个题的思路是啥子，反转链表，反转k个链表
        if (head == null || head.next == null | k == 0) {
            return head;
        }
        int n = 1;
        ListNode fastNode = head;
        while (fastNode.next != null) {
            fastNode = fastNode.next;
            n++;  //先算出来列表的长度
        }
        k = k % n;
        if (k == 0)
            return head;
        ListNode slowNode = head;
        for (int i = 0; i < n - k - 1; i++) {//找到其倒数第k个节点啊
            slowNode = slowNode.next;
        }
        ListNode newHead = slowNode.next;
        slowNode.next = null;
        fastNode.next = head;
        return newHead;
        // if(head==null||head.next==null||k==0) return head;
        // ListNode first = head;
        // ListNode second = head;
        // int n = 2;
        // while(second.next.next!=null){
        //     second=second.next;
        //     n++;

        // } 
        // k =k%n;
        // ListNode tmp = second.next;
        // second.next=null;
        // tmp.next=first;
        // return rotateRight(tmp, k-1);

    }
}
// @lc code=end
