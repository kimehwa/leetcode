/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        // 这种字符串的动态规划，写出来递归方程来
        // 1 如果2者字母相等，有两种情况，1两个都跳过，2 s跳过t可以不跳 如果两者字母不相等，s跳过，t不跳
        // 递归终止条件是s为空返回0，t为空返回1，可以用memo技术 ，更关键的是使用dp进行处理，动态规划可以倒着进行
        // int lens = s.length();
        // int lent = t.length();
        // int[][] dp = new int[lens + 1][lent + 1];// 这里基本都要大一个
        // for (int i = 0; i <= lens; i++) {
        //     dp[i][lent] = 1;
        // }
        // // 倒着进行，t每次增加一次字母
        // for (int i = lent - 1; i >= 0; i--) {// 从len-1开始倒，因为lent已经有值了
        //     dp[lens][i] = 0;// 默认是0 所以可以忽略
        //     for (int j = lens - 1; j >= 0; j--) {
        //         if (t.charAt(i) == s.charAt(j)) {
        //             //对应两种情况 ，选择或者不选择当前字母
        //             dp[j][i] = dp[j + 1][i + 1] + dp[j + 1][i];
        //         } else {
        //             //一种情况 不能选择当前字母
        //             dp[j][i] = dp[j + 1][i];
        //         }
        //     }
        // }
        // return dp[0][0];
        //二维转化为一维 ，用pre与temp进行设计
        int lens = s.length();
        int lent = t.length();
        int[] dp = new int[lens+1];//这里为啥设置lens
        for(int i= 0;i<=lens;i++){
            dp[i] = 1;
        }
        for(int i =lent-1;i>=0;i--){
            int pre = dp[lens];
            dp[lens]= 0;//给lens的地方赋值
            for(int j = lens-1;j>=0;j--){
                int temp = dp[j];
                if(s.charAt(j)==t.charAt(i)){

                    dp[j] = pre+dp[j+1];
                }else{
                    dp[j] = dp[j+1];
                }
                pre = temp;
            }
        }
        return dp[0];
    }
}
// @lc code=end
