/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double fastPow(double x, long n) {
        // 这个题又要处理好多次整数，这个题怎么用二分法？
        // 方法1 ：蛮力法 如果n小于0，可以用1/x，暴力法不通过
        // long N = n;
        // if (N < 0) {
        //     x = 1 / x;
        //     N = -N;
        // }
        // double res = 1;
        // for (long i = 0; i < N; i++) {//java中没有long  long的符号
        //     res = res * x;
        // }
        // return res;
        // ========方法2  快速幂======
        // 假定我们得到了x^n/2结果 想得到x^n的结果 那么我们可以让其乘两次，然后分为奇数和偶数进行处理即可
        if(n==0) return 1.0;
        double half = fastPow(x, n/2);
        if(n%2==0){//说明是偶数
            return half*half;
        }else{
            return x*half*half;
        }
    }
    public double myPow(double x,int n){
        long N =n;
        if(N<0){
            x=1/x;
            N=-N;
        }
        return fastPow(x, N);
    }
}
// @lc code=end
