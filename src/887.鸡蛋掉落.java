/*
 * @lc app=leetcode.cn id=887 lang=java
 *
 * [887] 鸡蛋掉落
 */

// @lc code=start
class Solution {

    public int superEggDrop(int K, int N) {
        // dp的转移方程是递归子式子
        // 最坏情况下，是两个问题中的最大者，并且我们在第k层扔下了，所以也算做一次
        // 考虑初始化，一般需要0状态，这里的第0层和第0个鸡蛋我们需要考虑进去，他们的值会被后来值参考，所以表格需要n+1，k+1‘列。分为第0
        // 行，第一行，第0列，第一列，输出就是第n，k
        // int[][] dp = new int[N + 1][K + 1];
        // for (int i = 0; i <= N; i++) {
        //     Arrays.fill(dp[i], i); // 把每一列的值求出
        // }
        // // 初始化，填写下标为0，1行和下标为0，1列的值
        // for (int j = 0; j <= K; j++) {// 楼层为0层的时候，不管鸡蛋个数是多少 都测不出来
        //     dp[0][j] = 0;
        // }
        // // 第一行 0个鸡蛋的时候次 其他的时候都是1次
        // dp[1][0] = 0;
        // for (int j = 1; j <= K; j++) {
        //     dp[1][j] = 1;
        // }
        // // 第0列，第一列，鸡蛋个数为0，测不出来，鸡蛋个数为1，f值为楼层高度
        // for (int i = 0; i <= N; i++) {
        //     dp[i][0] = 0;
        //     dp[i][1] = i;
        // }
        // // 从第二行第二列开始填表
        // for (int i = 2; i <= N; i++) {
        //     for (int j = 2; j <= K; j++) {
        //         for (int k = 1; k <= i; k++) { // 从第k层开始 到第i层结束,分为碎了和没碎
        //             dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);
        //         }
        //     }
        // }
        // return dp[N][K];
        // ===============
        int[][] dp = new int[N+1][K+1];
        for(int i = 0;i<=N;i++){
            Arrays.fill(dp[i],i); //把每一列的值求出
        }
        //初始化，填写下标为0，1行和下标为0，1列的值
        for(int j = 0;j<=K;j++){//楼层为0层的时候，不管鸡蛋个数是多少 都测不出来
            dp[0][j]=0;
        }
        //第一行 0个鸡蛋的时候次 其他的时候都是1次
        dp[1][0]=0;
        for(int j=1;j<=K;j++){
            dp[1][j]=1;
        }
        //第0列，第一列，鸡蛋个数为0，测不出来，鸡蛋个数为1，f值为楼层高度
        for(int i=0;i<=N;i++){
            dp[i][0]=0;
            dp[i][1]=i;
        }
        //从第二行第二列开始填表
        for(int i = 2;i<=N;i++){
            for(int j =2;j<=K;j++){
                int left=1,right= i;
                while(left<right){
                    //要找到dp[k-1][j-1]<=dp[i-mid][j]的最大值//因为根据i来看，一个递增一个递减，二者相遇的就是最大值
                    int mid = left+(right-left+1)/2;.
                    int breakCount = dp[mid-1][j-1];
                    int notBreakCount = dp[i-mid][j];
                    if(breakCount>notBreakCount){
                        right = mid-1;//严格大于的时候不是解
                    }else{
                        left = mid;
                    }
                    
                }
                dp[i][j]= Math.max(dp[left-1][j-1],dp[i-left][j])+1;
            }
        }
        return dp[N][K];
    }
    }

}
// @lc code=end
