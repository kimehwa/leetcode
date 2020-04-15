import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //这照类型的题一般用deque官方推荐的。
        int len = nums.length;
        boolean[] used = new boolean[len];
        Deque<Integer> pre = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if(len ==0) return res;
        Arrays.sort(nums);//所以这里要排序
        dfs(nums, 0, len, used, pre, res);
        return res;

        
    }
    public void dfs(int[] nums,int depth,int len,boolean[] used,Deque<Integer> pre,List<List<Integer>> res){
        if(len ==depth) {
            res.add(new ArrayList<>(pre));
            return ;
        }
        for(int i = 0;i<len;i++){
            //这里很重要  used[i-1]没有被选择  这样的防止下面有些不可以被剪支的减掉
            //i>0保证其有意义
            if(i>0&&nums[i-1]==nums[i]&&!used[i-1]) continue;
            if(!used[i]){
                pre.addLast(nums[i]);
                used[i]=true;
                dfs(nums, depth+1, len, used, pre, res);
                pre.removeLast();
                used[i]=false;
            }
        }
    }
}
// @lc code=end

