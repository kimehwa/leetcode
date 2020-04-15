import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // List<List<Integer>> res = new ArrayList<>();
        // Arrays.sort(nums);
        // dfs(nums, 0, new Stack<>(), res);
        // return res;
        // 方法2 ：用位运算符
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int subsetNum = 1 << nums.length; // 左移运算符
        for (int i = 0; i < subsetNum; i++) {
            List<Integer> list = new ArrayList<>();
            boolean illegal = false; // 这个位置？
            for (int j = 0; j < nums.length; j++) {
                if ((i >> j & 1) == 1) { // I的第j位为1
                    // 如果当前是重复数字，并且前一位为0，跳过这个选择
                    if (j > 0 && nums[j] == nums[j - 1] && (i >> (j - 1) & 1) == 0) {
                        illegal = true;
                        break;
                    } else {
                        list.add(nums[j]);
                    }
                }
            }
            if (!illegal)
                res.add(list);

        }
        return res;
    }

    public void dfs(int[] nums, int start, Stack<Integer> stack, List<List<Integer>> res) {
        res.add(new ArrayList<>(stack));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])// 关键是这个地方是怎么做的
                continue;
            stack.push(nums[i]);
            dfs(nums, i + 1, stack, res);
            stack.pop();
        }
    }
}
// @lc code=end
