/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        //用左右指针吗？
        // int left=0,right = s.length()-1;
        // while(left<right){//终止条件是二者相等  这里的char可以用0，9大于小于或者a到z表示
        //     //关键问题 string的api如何消去非关键元素以及空格
        //     if(s.charAt(left))
        // }
        s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c :s.toCharArray()){
            if(Character.isLetterOrDigit(c)) sb.append(c);//character有个静态类可以使用啊
        }
        return sb.toString().equals(sb.reverse().toString());

    }
}
// @lc code=end

