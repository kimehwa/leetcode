import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        // //回溯加剪支
        // List<String> res = new ArrayList<>();
        // if(n==0) return res;
        // dfs("",n,n,res);
        // return res;
        // ===============动态规划=========
        // 这个dp方程不好写，可能的对数加剩下的对数为i-1 ，所以剩下的为i-j-1;所以dp = （）+括号里+括号外的
        if(n==0){
            return new ArrayList<>();
        }
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);
        for(int i = 1;i<=n;i++){
            List<String> cur = new ArrayList<>();//每次生成一个dp
            for(int j=0;j<i;j++){
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i-j-1);
                for(String s1:str1){
                    for(String s2:str2){
                        cur.add("("+s1+")"+s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);

        
    }
    // public void dfs(String curRes,int left,int right,List<String> res){
    //     if(left==0&&right==0){
    //         res.add(curRes);
    //         return ;
    //     }
    //     if(left>right) return ;
    //     if(left>0){
    //         dfs(curRes+"(",left-1,right,res);
    //     }
    //     if(right>0){
    //         dfs(curRes+")", left, right-1, res);
    //     }
    // }
}
// @lc code=end

