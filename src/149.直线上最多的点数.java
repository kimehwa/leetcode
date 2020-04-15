import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        // 采用暴力解法：数学的在一条直线上的处理
        // 暴力法的数据过大，也可以造成溢出，用java的bigInteger方法
        // 暴力法的方案，将讲个分数约分到最简，判断分子分母是都相等，用辗转相除法进行处理
        // ==========用点斜式，然后用hash进行计数
        // 问题是斜率是小数，用分数表示 ，然后求分子分母的最大公约数，然后把分子+@+分母作为key去存储
        // 还有个问题是确定某个点，平面商行如果有和这个点重叠的话，按照正常约分，会出现除0，需要一个变量
        // 单独计算
        if (points.length < 3)
        return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            HashMap<String, Integer> map = new HashMap<>();//每次的hashmap都是新建的hash
            int max = 0;// 保存经过的直线中最多的点
            for (int j = i + 1; j < points.length; j++) {
                // 求斜率的分子与分母
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {// 说明两个点重合
                    duplicate++;
                    continue;
                }
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;
                String key = x + "@" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + duplicate + 1);// 代表当前的点和重复的点
        }
        return res;
    }

    private int gcd(int a, int b) {
        // 辗转相除法
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
        // if(a%b==0) return b;
        // return gcd(b, a%b);
    }
}
// @lc code=end
