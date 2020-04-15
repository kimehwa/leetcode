import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        //返回第k行，基于动态规划 倒着写就行
        int pre =1;
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i =1;i<=rowIndex;i++){
            // for(int j = 1;j<i;j++){
            //     int temp = res.get(j);//先保存上一个的值
            //     res.set(j, pre+res.get(j));//set的用法
            //     pre = temp; //跟动态规划的思路是一样的，保存其前一个位置的值
            // }
            for(int j = i-1;j>0;j--){
                res.set(j, res.get(j)+res.get(j-1));
            }
            res.add(1);
        }
        return res;
    }
}
// @lc code=end

