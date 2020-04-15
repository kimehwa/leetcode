import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    //自己写只出来了一个，这个是为什么呢？，dfs要判断哪个用到了，哪个没用到
    // public List<List<Integer>> res;
    // public List<List<Integer>> permute(int[] nums) {
    //     res = new ArrayList<>();
    //     if(nums.length==0) return res;
    //     dfs(nums, 0, new Stack<>());
    //     return res;

        
    // }
    // public void dfs(int[] nums,int start,Stack<Integer> pre){
    //     if(pre.size()==nums.length){
    //         res.add(new ArrayList<>(pre));
    //         return ;
    //     }
    //     for(int i = start;i<nums.length;i++){
    //         pre.add(nums[i]);
    //         dfs(nums, i+1, pre);
    //         pre.pop();
    //     }
    // }
    //数已经选够了，用一个depth来判断是第几层，还要有一个布尔数组，哪些数我们选过了

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) return res;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, len, 0, path, used, res);
        return res;

    }
    public void dfs(int[] nums,int len,int depth,List<Integer> path,boolean[] used,List<List<Integer>> res){
        if(len==depth){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i = 0;i<len;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i]= true;
                dfs(nums, len, depth+1, path, used, res);
                used[i] = false;
                path.remove(depth);
            }
        }
    }
}
// @lc code=end

