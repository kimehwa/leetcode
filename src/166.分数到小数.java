import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 这个题怎么用hashmap..用保存商，然后除以整数
        long num = numerator;
        long den = denominator;
        String sign = "";
        if (num > 0 && den < 0 || num < 0 && den > 0) {
            sign = "-";
        }
        num = Math.abs(num);
        den = Math.abs(den);
        long integer = num / den; // 记录整数部分
        num = num - integer * den; // 记录余数
        HashMap<Long, Integer> map = new HashMap<>();
        int index = 0;
        String decimal = ""; // 记录小数部分
        int repeatIndex = -1;
        while (num != 0) {
            num *= 10;// 作为新的被除数
            if (map.containsKey(num)) {
                repeatIndex = map.get(num);
                break;
            }
            map.put(num, index);
            long decimalPlace = num / den; // 保存当前的商
            decimal += decimalPlace; // 加到所有的商中,这里用stringbuilder怎么样呢？
            num -= decimalPlace * den;
            index++;
        }
        if (repeatIndex != -1) {// 说明存在 循环小数
            String dec = decimal;
            return sign + integer + "." + dec.substring(0, repeatIndex) + "(" + dec.substring(repeatIndex) + ")";
        } else {
            if (decimal == "") {
                return sign + integer;
            } else {
                return sign + integer + "." + decimal;
            }
        }

    }
}
// @lc code=end
