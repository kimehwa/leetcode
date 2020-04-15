import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 反转一次链表的问题，肯定需要dummy链表
        // // 先找到需要反转的前一个链表和后一个链表 用dummy防止删除首结点
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // ListNode cur = dummy;
        // ListNode start = null;
        // while (n >= -1) {
        //     cur = cur.next;
        //     m--;
        //     n--;
        //     if (m == 1) {
        //         start = cur;
        //     }
        // }
        // // ListNode start2 = start.next;
        // // start.next =cur;
        // start.next = reverseNode(start.next, cur);// 怎么把后面的接起来啊 所以这个不能用这个连接
        // return dummy.next;
        // 这个题就不用dummy
        // int len = 0;
        // ListNode node1 = head;
        // ListNode fPre = null;
        // ListNode tPos = null;// 找到待反转的前一个和后一个链表
        // while (node1 != null) {
        //     len++;
        //     fPre = len == m - 1 ? node1 : fPre;
        //     tPos = len == n + 1 ? node1 : tPos;
        //     node1 = node1.next;
        // }
        // if (m > n || m < 1 || n > len) { // 这里的判断条件放在后面是为了让其找到长度，精辟
        //     return head;
        // }
        // node1 = fPre == null ? head : fPre.next;// 看这里是否是头结点
        // ListNode node2 = node1.next;// 要反转的第一个节点
        // node1.next = tPos;// 首先记录下来反转的后面的节点 这里是先把后面正确的连接
        // ListNode next = null;
        // while (node2 != tPos) {
        //     next = node2.next;
        //     node2.next = node1;
        //     node1 = node2;
        //     node2 = next;// 尾节点本来就是连起的
        // }
        // if (fPre != null) {// 说明不是尾部节点
        //     fPre.next = node1;
        //     return head;
        // }
        // return node1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        for(int i = 1;i<m;i++){ //找到反转的前一个节点
            cur  = cur.next;
        }
        ListNode nextHead = cur.next;//这段需要反转的起点
        ListNode pre = null;
        ListNode next = null;
        for(int i = m;i<=n;i++){//反转m与n之间的链表
            next = nextHead.next;//这里不能放在for循环里  出不来的  不能再for循环里面定义
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;//这里返回的是
        }
        //如何正确的连接链表  next是留着的一个节点 ，此时已经被剪断 卧槽 这个题的图真吉尔好用啊；
        cur.next.next = next;
        cur.next = pre;
        return dummy.next;


    }

    public ListNode reverseNode(ListNode start, ListNode end) {// 这个反转这里的边界条件
        ListNode cur = start;
        ListNode pre = end;//这里的反转可以这么做
        while (cur != end) {
            ListNode next = cur.next; // 首先要记录下来cur.next 否则就会丢失信息
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;//后面少了是因为吧反转后面的链表切走了 怎么样正确的连接前一个节点与后一个节点
    }
}
// @lc code=end
