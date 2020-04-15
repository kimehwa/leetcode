import java.util.List;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        // 这个题说是用回溯法，其实就是用的动态规划的方法
        List<Integer> gray = new ArrayList<>();
        gray.add(0);// 初始化0处理，
        // 格雷码n与n+1的关系，前n/2的时候是一样的，后面为其逆序加上2^n即可
        for (int i = 0; i < n; i++) {
            int add = 1 << i;// 要加的数字
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;

    }
}
// @lc code=end
