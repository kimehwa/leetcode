import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new Stack<>());
        return res;

    }
//树的下一层，所有出现的避免这样操作。
    public void dfs(int[] candidates, int target, int start, Stack<Integer> pre) {
        if (target == 0) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            if(i>start&&candidates[i-1]==candidates[i]) continue;
            pre.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, pre);// 跟那个只有这里不同吗
            pre.pop(); // 把最后一个移除；
        }
    }
    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    //     int len = candidates.length;
    //     List<List<Integer>> res  = new ArrayList<>();
    //     if(len==0) return res;
    //     Arrays.sort(candidates);
    //     Deque<Integer> path = new ArrayDeque<>(len);
    //     dfs(candidates, len, 0, target, path, res);
    //     return res;

    // }
    // public void dfs(int[] candidates,int len,int begin,int residue,Deque<Integer> path,List<List<Integer>> res){
    //     if(residue==0){
    //         res.add(new ArrayList<>(path));//这里都是一样的
    //         return ;
    //     }
    //     // 两个剪纸
    //     for(int i=begin;i<len;i++){ //这里是从begin开始的啊 怪不得
    //         if(residue-candidates[i]<0) break;
    //         if(i>begin&&candidates[i]==candidates[i-1]) continue;//小剪支
    //         path.addLast(candidates[i]);
    //         dfs(candidates, len, i+1, residue-candidates[i], path, res);
    //         path.removeLast();
    //     }
    // }
}
// @lc code=end
