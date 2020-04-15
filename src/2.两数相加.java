/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 两个链表的问题，可以新建一个链表，然后把链表逆序输出？
         * 相加题要涉及到进位输出啊
         */
        ListNode dumpHead = new ListNode(0);//这个哑结点有什么用呢？
        ListNode p = l1,q = l2,cur = dumpHead;
        int carry = 0;
        while(p!=null||q!=null){//这里是或者不是和，两个满足一个即可
            //要防止为0的情况
            int x = (p!=null)?p.val:0;
            int y = (q!=null)?q.val:0;//这里得到了两个节点的值
            int sum = x+y+carry;
            carry = sum/10;//这里更新carry的值
            cur.next = new ListNode(sum%10);//更新链表的值
            cur = cur.next;//这里更新下一个cur的位置
            if(p!= null) p = p.next;
            if (q!=null)  q = q.next;
        }
        if (carry>0) {
            cur.next = new ListNode(1);
        }
        return dumpHead.next;//这里返回哑结点的下一个节点
    }
}
// @lc code=end

