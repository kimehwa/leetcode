import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
class Solution {
    int n;// 为单词的数量吗
    String s;
    LinkedList<String> segments = new LinkedList<>();
    ArrayList<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // 这个题有想到怎么去剪支了，这个题怎么想啊
        n = s.length();
        this.s = s;
        dfs(-1, 3);
        return res;

    }

    // 首先判断是否有效
    public boolean valid(String segment) {
        int m = segment.length();
        if (m > 3) {
            return false;
        }
        // 如果不为0 返回是否小于255 为0 看位数是否为1
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }

    public void update(int currpos) {
        String segment = s.substring(currpos + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            res.add(String.join(".", segments));// string的join函数
            segments.removeLast();
        }
    }

    public void dfs(int prevpos, int dots) {
        int maxpos = Math.min(n - 1, prevpos + 4);// 下一个的范围是从1到4 最大是4，但是有个界限是n
        for (int currpos = prevpos + 1; currpos < maxpos; currpos++) {
            String segment = s.substring(prevpos + 1, currpos + 1);// 依次尝试每一个dots
            if (valid(segment)) {
                segments.add(segment);
                if (dots - 1 == 0)
                    update(currpos);
                else
                    dfs(currpos, dots - 1);
                segments.removeLast();
            }
        }
    }
}
// @lc code=end
