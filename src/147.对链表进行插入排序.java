/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        // 这个题左神的算法上有。插入排序。这个题需要用线性表进行处理吗，这个题怎么处理？
        // 是不是还要处理一个尾部节点
        // ListNode curr = head;
        // ListNode cur = head;
        // while (cur != null) {//这里的问题 直接处理当下的即可啊
        //     ListNode tmp = cur.next.next;
        //     ListNode now = cur.next;
        //     while (curr.next.val < now.val) {
        //         curr = curr.next;
        //     }
        //     ListNode temp = curr.next;
        //     curr.next = now;
        //     now.next = temp;
        //     cur = tmp;
        // }
        // return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        ListNode cur = head;
        while(cur!=null){
            if(end.val<cur.val){//如果是升序，那么遍历下一个位置
                end.next = cur;
                end = cur;
                cur = cur.next;
            }else{//如果不是升序
                ListNode tmp = cur.next;//先保存下cur的下一个节点防止丢链表
                end.next = tmp; //断开要排的元素
                //从头判断找到合适的插入的位置
                while(pre.next!=null&&pre.next.val<cur.val){
                    pre=pre.next;
                }
                //找到之后开始连接新顺序
                cur.next =pre.next;
                pre.next = cur;
                // 吧定位指针归为原始
                pre = dummy;
                cur = tmp; //cur也进位
            }
        }
        return dummy.next;
    }
}
// @lc code=end
