import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 这个题好像是看过，这个题的思路是？贪心算法？怎么想这个算法，先要懂暴力算法 是一个环形 是一个双指针的问题
        // int n = gas.length;
        // for (int i = 0; i < n; i++) {
        //     int j = i;
        //     int remain = gas[i];
        //     while (remain - cost[j] >= 0) {
        //         remain = remain - cost[j] + gas[(j + 1) % n];// 新的点的补给
        //         j = (j + 1) % n;
        //         if (j == i)
        //             return i; // 说明是环形 回来了
        //     }
        // }
        // return -1;
        // =====优化方法1：空间换时间；优化方法2：反证法======
        //反证法的处理是从i开始跳，假设最远跳到j，那么从i+1到j的节点就不可能绕一圈了，
        //因为假设i+1的节点能绕一圈，那么意味着从i+1开始一定能到j+1，因为能到到达i+1，所以i也能到达j+1
        //这与之产生了矛盾
        int n = gas.length;
        for(int i = 0;i<n;i++){
            int j = i;
            int remain = gas[i];
            while(remain-cost[j]>=0){
                remain = remain-cost[j]+gas[(j+1)%n];//处理环形数组经常用这个方法
                j= (j+1)%n; //j也要实时更新
                if(j==i) return i;
            }
            //最远距离绕到了之前，i后面所有的都绕不成一圈了
            if(i>j){
                return -1;
            }
            i=j; //i直接跳到j，外层for循环执行i++，相当于从j+1开始考虑的
        }
        return -1;
    }
}
// @lc code=end
