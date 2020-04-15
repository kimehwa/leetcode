import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        // 按行排序，按照当前行和当前方向两个变量对合适的行进行追踪，只有移动到最上的行或者最下的行时，方向才会改变
        if (numRows == 1)
            return s;
        // 数组需要经历向下向右，所以要有一个布尔变量。并不需要一个跟图形完全对应起来
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false; // 行的变化
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);// 把这一行的添加上去
            // curRow+1h或者减少1，跟goingdown有关
            if (curRow == 0 || curRow == numRows-1)//yinwei是从0开始
                goingDown = !goingDown;
            curRow += (goingDown) ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows)
            res.append(row);
        return res.toString();
    }
}
// @lc code=end
