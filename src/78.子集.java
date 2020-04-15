import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 关键是怎么去重啊，用二进制的和位运算，集合中的每个数都可以选或者不选
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<(1<<nums.length);i++){//左移运算符相当于2的n次方。，n个数字的数组，一共有2^n个子集
            List<Integer> sub = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                //第2个问号处，以0~(2^n)-1，2^n个n位二进制数，对应于所有子集，从后往前第 j 个二进制位为 
                // 0 表示不放入第 j 个元素,同理1表示放入。" ((i >> j) & 1) == 1 " 表示对于二进制数i，
                // 从低位到高位逐个取其二进制位，并判断是否为1，若为1则放入对于nums中的元素。

                if(((i>>j)&1)==1) sub.add(nums[j]);
            }
            res.add(sub);
        }
        return res;
        // ==============方法2 ：逐个枚举===========
        //是一个比较完整的中序遍历，回溯问题
    //     List<List<Integer>> res = new ArrayList<>();
    //     Stack<Integer> stack = new Stack<>();
    //     dfs(nums, 0, stack, res);
    //     return res;

        
    // }
    // public void dfs(int[] nums,int index,Stack<Integer> stack,List<List<Integer>> res){
    //     res.add(new ArrayList<>(stack));//每一个都符合题意
    //     for(int i = index;i<nums.length;i++){
    //         stack.push(nums[i]);
    //         dfs(nums, i+1, stack, res);
    //         stack.pop();
    //     }
    }
}
// @lc code=end

