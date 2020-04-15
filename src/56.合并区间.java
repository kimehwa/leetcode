import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    private static class Interval { // 内部类
        int start;
        int end;

        Interval(int[] interval) {
            this.start = interval[0];
            this.end = interval[1];
        }

        int[] toArray() {//这个是collection的一个接口
            a
            return new int[] { this.start, this.end };
        }
    }

    // 写比较器
    private static class IntervalCompartor implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {// 如果返回的值大于0说明a>b
            return Integer.compare(a.start, b.start);
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> list = new LinkedList<>();// 这里为什么用链表
        for (int[] interval : intervals) {
            list.add(new Interval(interval));// 生成了这么多对象
        }
        list.sort(new IntervalCompartor());// 传入比较器进行排序
        LinkedList<Interval> merged = new LinkedList<>();// 一个合并数组//z这里的错误这样转为list了
        for (Interval interval : list) {
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        // interval类已经合并完毕
        int i = 0;
        int[][] res = new int[merged.size()][2];
        for (Interval mergedInterval : merged) {
            res[i] = mergedInterval.toArray();// 二维数组可以写成一个数组
            i++;//这里不能遗忘了
        }
        return res;

    }
}
// @lc code=end
