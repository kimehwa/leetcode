/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void reorderList(ListNode head) {
        // 这个题怎么处理 ，链表ode？。链表的一个缺点是不能随机存储，需要把其放入一个线性表中
        // if (head == null)
        //     return;
        // List<ListNode> list = new ArrayList<>();
        // while (head != null) {
        //     list.add(head);
        //     head = head.next;
        // }
        // int i = 0, j = list.size() - 1;
        // while (i < j) {
        //     list.get(i).next = list.get(j);
        //     i++;
        //     if (i == j)
        //         break;// 如果是偶数个的话二者会提前相遇
        //     list.get(j).next = list.get(i);
        //     j--;
        // }
        // list.get(i).next = null;// 相遇后的尾结点要处理一下
        // ===================方法2：递归的代码===================
        // if(head == null||head.next==null||head.next.next == null) return ;
        // int len = 0;
        // ListNode h = head;
        // while(h!=null){
        //     h=h.next;
        //     len++;
        // }
        // reorderListHelper(head, len);
        // ==========方法3.找到重点，然后逆序后半部分，然后合并
        if(head == null||head.next==null||head.next.next == null){
            return;
        }
        ListNode slow = head,fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;//从中间分开
        //第二步：逆序newHead.这一步可以写为一个函数中
        ListNode pre =null,cur = newHead;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre =cur;
            cur = next;
        }
        newHead = cur;
        while(newHead!=null){
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }

    }
    public ListNode reorderListHelper(ListNode head,int len){
        if(len==1){
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if(len==2){
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        ListNode tail = reorderListHelper(head.next, len-2);//12345那么他的tail是4
        ListNode subHead = head.next;
        head.next = tail;
        ListNode outTail = tail.next;//上一层head对应的tail
        tail.next = subHead;
        return outTail;
    }
}
// @lc code=end
