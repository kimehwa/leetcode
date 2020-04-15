/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        // 这个题也是贪心撒
        // } 暴力法，先给每个人都一颗糖果，然后看左边的人评分是否比i低并且左边的糖果是否比i高，如果是 就更新i
        // 的糖果 ，同样的方法检查右边的 ，然后对数组重复处理，如果某次中 不出现变化 那么意味着已经到达最后分布，可以tingzhi
        // return sum; 编码可以用一个flag标志位来退出
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);// 初始为1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) { // 因为之前每一个都是相等的
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {// 如果i比i+1的值大，我们更新
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }
}
// @lc code=end
