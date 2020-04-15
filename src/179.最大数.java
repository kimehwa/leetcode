import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        // 最大数，这个题的思路是？这个题应该怎么写这个？
        // StringBuilder sb = new StringBuilder();
        // 按照道理要实现一个compareble的接口？按照位数排。然后依次取出来
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(asStrs, new LargestNumberComparator());
        if (asStrs[0].equals("0"))
            return "0";
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }
        return largestNumberStr;

    }

    public class LargestNumberComparator implements Comparator<String> {
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
}
// @lc code=end
