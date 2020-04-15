import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 */

// @lc code=start
class Solution {
    private boolean[] used;
    private int[] factorial;
    private int n;
    private int k;
    private List<Integer> path;

    public String getPermutation(int n, int k) {
        // 回溯法与数学法
        // 思路，把n！个排列分为n组，每组有n-1!个排列，根据k值可以确定是第几组第几个选
        // 选取该排列的第一个数字，然后递归从剩余的数字取下一个数字，剪支看这个枝的个数是否比k大
        //这个题实际上没有进行回溯
        this.n = n;
        this.k = k;
        used = new boolean[n + 1];
        Arrays.fill(used, false);
        // 计算阶乘数组
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i; // 阶乘数组的完成
        }
        path = new ArrayList<>(n);
        dfs(0);
        StringBuilder sb = new StringBuilder();
        for (Integer c : path) {
            sb.append(c);
        }
        return sb.toString();

    }

    private void dfs(int index) {
        if (index == n)
            return;
        int cnt = factorial[n - 1 - index];// 还没有确定的全排列的个数，初始为n-1的下标
        for (int i = 1; i <= n; i++) {
            if (used[i]) //这一层的标记是什么意思呢？
                continue;
            if (cnt < k) {
                k -= cnt;// 这里进行剪支
                continue;
            }
            path.add(i);
            used[i] = true;
            dfs(index + 1);//因为里面又要进行递归 ，递归又要重新从1开始进行
        }

    }

    // 求n
    private int factorial(int n) {
        int res = 1;
        for (int i = n; i > 1; i--) {
            res = res * i;
        }
        return res;
    }
}
// @lc code=end
