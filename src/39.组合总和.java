import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //也是用回溯做，前一个月做过，在过一遍思路
        int len =candidates.length;
        if(len==0) return res;
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new Stack<>());
        return res;


    }
    public void dfs(int[] candidates,int target,int start,Stack<Integer> pre){
        if(target ==0){
            res.add(new ArrayList<>(pre));
            return ;
        }
        for(int i = start;i<candidates.length&&target-candidates[i]>=0;i++){
            pre.add(candidates[i]);
            dfs(candidates, target-candidates[i], i, pre);
            pre.pop();//还是不明白这里为啥要pop,每次回溯把最后一次加入的元素删除。
        }
    }
}
// @lc code=end

