import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    private String[] letterMap = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private ArrayList<String> res ; //因为这个编程了一个全局变量
    public List<String> letterCombinations(String digits) {
        //重做一遍回溯的题
        res = new ArrayList<>();
        if(digits.equals("")){
            return res;
        }
        dfs(digits, 0, "");
        return res;


        
    }
    public void dfs(String digit,int index,String s){ //深度遍历
        if(index==digit.length()){
            res.add(s);
            return ;
        }
        Character c = digit.charAt(index);
        String letters = letterMap[c-'0'];//找到index的索引
        for(int i = 0;i<letters.length();i++){
            dfs(digit, index+1, s+letters.charAt(i));
        }
        return ;
    }
}
// @lc code=end

