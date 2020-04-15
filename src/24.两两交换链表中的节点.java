/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // if (head == null || head.next == null)
        //     return head;
        // // ListNode firstNode = head;
        // ListNode secondNode = head.next;
        // head.next = swapPairs(secondNode.next);
        // secondNode.next = head;
        // return secondNode;
//===================尝试写一下非递归法=======
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;
        while(head!=null&&head.next!=null){
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            //反转
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            //初始化
            prevNode= firstNode;
            head = firstNode.next;//这里直接跳head。把前面两个都就更新了
        }
        return dummy.next;
    }
}
// @lc code=end
