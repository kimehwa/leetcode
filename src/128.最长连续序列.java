import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestLenght = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {// 说明找到了最长的子序列的起点
                int currentNum = num;
                int currentLenght = 1; // 因为序列会很多 所以要设计一个当前的最大值
                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLenght++;
                }
                // 要在代码里啊
                longestLenght = Math.max(longestLenght, currentLenght);
            }
        }
        return longestLenght;
    }
}
// @lc code=end
