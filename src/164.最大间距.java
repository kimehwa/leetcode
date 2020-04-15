import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        // 线性时间 规定了不能用排序法
        // 这个题用基数排序 时间复杂度是kn，当k远小于n的时候可以看做n
        // 方法1：基数排序
        // if (nums.length <= 1) {
        //     return 0;
        // }
        // List<ArrayList<Integer>> list = new ArrayList<>();
        // for (int i = 0; i < 10; i++) {
        //     list.add(new ArrayList<>());
        // }
        // int n = nums.length;
        // int max = nums[0];
        // for (int num : nums) {// 找到其中的最大值
        //     if (num > max) {
        //         max = num;
        //     }
        // }
        // int m = max;
        // int exp = 1;// 一位一位的进行比较
        // while (max > 0) { // 这里模仿的基数排序 ，一共排序n位次
        //     // 把之前的元素清空
        //     for (int i = 0; i < 10; i++) {
        //         list.set(i, new ArrayList<>());
        //     }
        //     for (int i = 0; i < n; i++) {
        //         // 对于取各位的数字，先对数字除以1，10，100，然后进行取余即可
        //         list.get(nums[i] / exp % 10).add(nums[i]);
        //     }
        //     // 把数字依次拿出来
        //     int index = 0;
        //     for (int i = 0; i < 10; i++) {
        //         for (int j = 0; j < list.get(i).size(); j++) {
        //             nums[index++] = list.get(i).get(j);
        //         }
        //     }
        //     max /= 10;
        //     exp *= 10;
        // }
        // int maxGap = 0;
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i + 1] - nums[i] > maxGap) {
        //         maxGap = nums[i + 1] - nums[i];
        //     }
        // }
        // return maxGap;
        // ===========方法2 桶排序：左神讲过这个题========
        //这个数据结构用两个数组就可以搞定啊，因为我们只需要一个最值即可。为什么首位不需要考虑？
        //鸽笼原理 如果n个数字，需要n-1个箱子，首位不需要考虑 做差的时候没有用到 首位和末位 没办法通过相邻的做差
        math.cell取整数
    }
}
// @lc code=end
