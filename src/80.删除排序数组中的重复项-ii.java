/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1, count = 1, length = nums.length;
        while (i < length) {
            if (nums[i - 1] == nums[i]) {
                count++;
                if (count > 2) {
                    removeElement(nums, i);// 此时这个i的地方已经被别的数字占据
                    i--;
                    length--;// 因为此时已经删除了一个元素，所以就减去了一个lenght
                }
            } else {
                count = 1;
            }
            i++;
        }
        return length;
    }

    public int[] removeElement(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];// 删除就是每一个后面的把前面的都覆盖掉
        }
        return arr;
    }
}
// @lc code=end
