/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        // 感觉这个题左程云的书上有，果然有，而且才是2星难度
        // 生成两个变量，一个l，一个r，（1，l）上表示已经包含的整数范围（1，r)shang表是遍历到目前为止
        // 可能在后序出现的整数范围
        // 分为4种情况
        // 可以排序后用二分法进行处理 从1开始二分查找每一个数，如果找到就下一个，否则就返回，这个还要排序
        // 这个题用到了鸽笼原理，把合适的数的下标放在相应的位置上，
        // 排序的规则是，如果这个数字i落在区间范围内，i就应该放在索引为i-1的位置上，不和谐的地方加1
        // 妈的 左程云那个讲的那么复杂，其实很简单的一个题
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end
