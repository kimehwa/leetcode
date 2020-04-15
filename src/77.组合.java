import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        if (n <= 0 || k <= 0 || n < k)
            return res;
        dfs(1, new LinkedList<>());
        return res;

    }

    // ========按顺序取 我终于知道这个了 =========虚幻中的i=begin与i=0就是是否判断用过boolean判断的数组来了
    public void dfs(int begin, LinkedList<Integer> pre) {
        if (pre.size() == k) {
            res.add(new LinkedList<>(pre));
            return;
        }
        for (int i = begin; i <= n - (k - pre.size()) + 1; i++) {// 这里可以进行剪支
            pre.add(i);
            dfs(i + 1, pre);
            pre.removeLast();
        }
    }
}
// @lc code=end
