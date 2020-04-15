/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //返回一个深拷贝
        // Node dummy = new Node(0);
        // Node newHead = new Node(head.val);
        // newHead.random = head.random;
        // dummy.next = newHead;
        // while(head!=null){  //我这个朴素的想法哪里出现问题了
            
        //     head = head.next;
        //     Node nextHead = new Node(head.val);
        //     nextHead.random = head.random;
        //     newHead.next = nextHead;
        //     newHead = nextHead;
        // }
        // return dummy.next;
        // ============核心思路=============
        // 第一步先复制节点，第二步：复制连接指针 第三步：分离复制链表和源链表 第四步：返回
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next = null;
        //第二步： 复制链表，只复制next指针，不复制random指针
        while(cur!=null){//复制指针
            next = cur.next;
            Node newNode = new Node(cur.val);
            newNode.next = next;
            cur.next = newNode;
            cur = next;
        }
        //第三步：复制random指针
        cur = head;
        while(cur!=null){
            next = cur.next.next;
            cur.next.random= cur.random==null?null:cur.random.next;//这里加next 是因为复制的那份数组啊
            cur = next;
        }
        //把两个数组分开
        cur = head;
        Node newHead = cur.next;//保留头结点而已
        Node copyCur = null;
        while(cur!=null){
            next = cur.next.next;
            copyCur = cur.next; //现在
            cur.next = next;
            copyCur.next = next!=null?next.next:null;
            cur = next;
        }
        return newHead;
        // ===========还可以用hash表把新旧结点映射起来
        // 然后设置值的random与
    }
}
// @lc code=end

