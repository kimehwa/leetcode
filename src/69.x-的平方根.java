/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
    //二分法：（x/2）^2>x 所以可以进行二分
    //这里的int改为long
        long left = 0;
        long right = x/2+1;//为了照顾1处理出了右边界
        while(left<right){//还是以前的那个模板
            long mid  = (left+right+1)>>>1; //这里要去取右中位数
            long square = mid*mid;
            if(square>x){
                right = mid-1;
            }else{
                left = mid;  //因为是向下取整的 所以不能再左边界进行坍塌。
            }

        }
        return (int)left;



    }
}
// @lc code=end

