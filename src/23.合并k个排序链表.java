import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 新建一盒大小为len的小跟堆，然后每次从堆顶拿下来最小值，判断是否有next节点，有的话继续添加到跟堆中，依次类推
        if (lists == null || lists.length == 0) {
            return null;
        }
        int len = lists.length;
        if (len == 1)
            return lists[0];
        // 两个以上链表的情况
        ListNode prehead = new ListNode(0);// 这里方便返回值
        ListNode cur = prehead;// 这里是方便取指
        PriorityQueue<ListNode> minheap = new PriorityQueue<>(len, (a, b) -> (a.val - b.val));
        //比较方法，如果第二个大于第一个  就是大根堆了
        for (ListNode list : lists) {
            if (list != null)
                minheap.offer(list);// 装的是链表；
        }
        while (!minheap.isEmpty()) {
            ListNode minNode = minheap.poll();
            cur.next = minNode;
            cur = cur.next;
            if (minNode.next != null) {
                minheap.offer(minNode.next);
            }
        }
        return prehead.next;
    }
}
// @lc code=end
