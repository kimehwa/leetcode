import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    //哈希表存储的是已经遍历过的node值，值是复制后的node值
    // private HashMap<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        // //用dfs与bfs进行处理吗？ 这个题要理解bfs和dfs的区别
        // //用hashmap记录已经出现的值 防止出现死循环
        // if(node==null) return node;
        // if(visited.containsKey(node)){
        //     return visited.get(node);
        // }
        // Node cloneNode = new Node(node.val,new ArrayList<>());
        // visited.put(node,cloneNode);
        // for(Node neighbor:node.neighbors){
        //     cloneNode.neighbors.add(cloneGraph(neighbor));
        // }
        // return cloneNode;
        //================================下面是bfs方法=====
        //bfs的套路我基本上掌握了
        if(node ==null) return node;
        HashMap<Node,Node> visited = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node,new Node(node.val,new ArrayList<>()));
        while(!queue.isEmpty()){
            Node n = queue.remove();
            for(Node neighbor:n.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));//这一步还是有点？
            }
        }
        return visited.get(node);

    }
}
// @lc code=end

