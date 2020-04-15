import java.math.BigInteger;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        //用与运算进行求和与异或运算
        // BigInteger x = new BigInteger(a,2);
        // BigInteger y = new BigInteger(b,2);
        // BigInteger zero = new BigInteger("0", 2);
        // BigInteger carry,answer;
        // while(y.compareTo(zero)!=0){//当进位消失了说明处理完毕了
        //     answer = x.xor(y); //异或
        //     carry = x.and(y).shiftLeft(1);  //与左移
        //     x =answer;
        //     y=carry;

        // }
        // return x.toString(2);//tostring改写了大数
        //===========方法2===========
        StringBuilder res = new StringBuilder();
        int ca = 0;
        for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){
            //java的for循环可以同时写2个
            int sum =ca;
            sum+=(i>=0?a.charAt(i)-'0':0);//当i小于0时候，说明需要补0
            sum+=(j>=0?b.charAt(j)-'0':0);

            res.append(sum%2);//如果相加为2，说明进位了
            ca = sum/2; //算进位，其实跟前面的很像
        }
        res.append(ca==1?ca:"");//判断最后一位是否有进位，有就升级
        return res.reverse().toString();

    }
}
// @lc code=end

