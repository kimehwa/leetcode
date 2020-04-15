import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 这个题用hashmap做，双指针排除
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            // 如果排序第一个乘以4大于target，直接判断退出
            if (nums[i] * 4 > target)
                break;
            // 跳过相同的解
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = len - 1; j - i > 2; j--) {
                if (nums[j] * 4 < target)
                    break;
                if (j < len - 1 && nums[j] == nums[j + 1])
                    continue;
                int left = i + 1, right = j - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right] + nums[j];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));// java转成数组
                        while (left < len - 2 && nums[left + 1] == nums[left]) {// 跳过相同元素
                            left++;
                        }
                        while (right > 2 && nums[right - 1] == nums[right])
                            right--;
                        left++;
                        right--;
                    } else if (target < sum) {
                        while (right > 2 && nums[right - 1] == nums[right])
                            right--;
                        right--;
                    } else {
                        while (left < len - 2 && nums[left + 1] == nums[left]) {// 跳过相同元素
                            left++;
                        }
                        left++;
                    }

                }
            }

        }
        return res;

    }
}
// @lc code=end
