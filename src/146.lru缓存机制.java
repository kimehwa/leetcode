import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {

    // 卧槽他阿妈的 lru缓存又忘了，我这脑子是浆糊吧
    // 双向链表的好处是不需要额外信息删除一个节点，同时可以从常数时间内从头部或者尾部删除节点
    // 在双向链表中，使用一个伪头部和伪尾部进行标记界限，这样更新的时候不用检查是否是null节点
    //用头尾两个哨兵
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {// 从尾部弹出一个
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;// 这里维护了头结点和尾节点

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;// 初始化一个头尾节点进行处理 然后进行加载更新
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null)
            return -1;
        moveToHead(node);// 加到头结点上
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = popTail();
                // removeNode(tail);
                cache.remove(tail.key);//从缓存中删除这个键值对
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
