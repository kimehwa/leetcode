import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        //这个题有进位 如果进位了怎么重新做一个数组呢？用array。copy？
        int carry = 0,len = digits.length-1;
        carry=(digits[len]+1)/10;
        digits[len]=(digits[len]+1)%10;
        
        for(int i = len-1;i>=0;i--){
            if(carry==0){
                break;
            }
            int num = (digits[i]+carry)%10;
            carry=(digits[i]+carry)/10;//我这是每一位都加1了
            digits[i]=num;
        }
        if(carry==1){
            int[] newInt = new int[len+2];
            newInt[0]=1;
            
            return newInt;
        }
        return digits;
        // return digits;  注意这里 999 进位了  就是1000，只需要初始化第一个参数即可
        // for (int i = digits.length - 1; i >= 0; i--) {
        //     digits[i]++;
        //     digits[i] = digits[i] % 10;
        //     if (digits[i] != 0) return digits;
        // }
        // digits = new int[digits.length + 1];
        // digits[0] = 1;
        // return digits;



    }
}
// @lc code=end

