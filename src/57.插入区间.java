import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 跟上一个题差不多，写返回二维数组。
        // 贪心方法，有重合就合并他们 尝试自己写一下代码
        int newstart = newInterval[0], newend = newInterval[1];
        int index = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<>();// 这个泛型里还可以填数组？基本类型额
        while (index < n && newstart > intervals[index][0]) {// 当首位比新开始的地方大
            output.add(intervals[index++]);// 写一位数组会把一个数组写进去
        }
        int[] interval = new int[2];// 开始合并新数组
        if (output.isEmpty() || output.getLast()[1] < newstart) {
            output.add(newInterval);
        } else {// 处理了前面的两种情况
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newend);
            output.add(interval);
        }
        while (index < n) {
            interval = intervals[index++];
            int start = interval[0], end = interval[1];
            if (output.getLast()[1] < start) {
                output.add(interval);
            } else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);// 这里用到了collection接口的第二种toarray方法

    }
}
// @lc code=end
