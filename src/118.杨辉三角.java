import java.util.ArrayList;
import java.util.List;

import sun.util.locale.provider.JRELocaleConstants;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        // if(numRows==0){
        //     return res;
        // }
        // res.add(new ArrayList<>());
        // res.get(0).add(1);//这是先把第一行的写完
        // for(int i =1; i<numRows;i++){
        //     List<Integer> row = new ArrayList<>();

        //     List<Integer> prevRow = res.get(i-1); //得到上一行的数据
        //     row.add(1);//得到第一个数据
        //     for(int j =1;j<i;j++){
        //         row.add(prevRow.get(j-1)+prevRow.get(j));
        //     }
        //     row.add(1);//最后一行为1
        //     res.add(row);
        //  }
        //  return res;
        
        // List<Integer> ans = new ArrayList<>();
        
        
        // for(int i = 0;i<numRows;i++){
        //     ans.add(0,1);
            
        //     for(int j = 1;j<i;j++){
        //         ans.set(j,ans.get(j-1)+ans.get(j));//arrayList的api还是没弄熟练
        //     }
        //     ans.add(1);
        //     res.add(new ArrayList<>(ans));
        // }
        // return res;
        List<List<Integer>> allrows = new ArrayList<>();
        ArrayList<Integer> rows = new ArrayList<>();
        for(int i = 0;i<numRows;i++){
            rows.add(0, 1);
            for(int j= 1;j<rows.size()-1;j++){
                rows.set(j, rows.get(j)+rows.get(j+1));
            }
            allrows.add(new ArrayList<>(rows));
        }
        return allrows;
    }
}
// @lc code=end

