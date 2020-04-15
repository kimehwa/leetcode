/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        /**
         * 判断一个数字是回文数，能想到的第一个思路是倒序后然后跟正序的对比一下 第二种思路是数学解法，用取第一位和最后一位进行对比，然后继续比较一直到二者相遇
         * 
         */
        if (x < 0) {// 说明是负数直接返回false
            return false;
        }
        int div = 1;// 这里是干什么用的？
        while (x / div >= 10)
            div *= 10;// 这里的div找到了最大位数
        // 第二个while循环的逻辑是ƒ
        while (x > 0) {
            int left = x / div;

            int right = x % 10;
            if (left != right) {
                return false;
            }
            // x这里应该去掉首位两项
            x = (x % div) / 10;
            div /= 100;// div这里减少两位
        }

        return true;

    }
}
// @lc code=end
