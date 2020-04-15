import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        /**
         * 查找字符串中数组的最长公共前缀，
         * 具体思路，1如果数组为空，直接返回
         * 2.令最长公共前缀ans为第一个字符串，进行初始化
         * 3遍历后面的字符串，一次将其与ans进行比较，两两找到最长前缀，最终结果就是最长公共前缀
         * 4如果查找过程中出现ans为空的情况，那么就说明公共前缀不存在，直接返回
         * 5时间复杂度为s，s为数组内的所有字符的长度的和
         * 字符串的indexOf方法是什么？返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1
         
        if (strs.length==0) {//如果为0，直接返回空的。这里的返回值需要定义一下
            return ""; 
        }
        String ans = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for(;j<ans.length()&&j<strs[i].length();j++){//内层循环完成比较
                if(ans.charAt(j)!=strs[i].charAt(j)){//如果不相等直接退出循环
                    break;
                }   
            }
            ans = ans.substring(0, j);//这里更新ans的值
            if(ans.equals("")){
                return ans;//如果是空直接返回，这样节省了时间，这里不可以去掉
            }
        }
        return ans;*/
        /**
         * 方法2，这个题可以采用分治法，跟快速排序的思路差不太多，时间复杂度可以简化很多
         * 分治法好像跟归并排序很像啊
         */
            if(strs==null||strs.length==0){
                return "";
            }
            return LongestCommonPrefix(strs, 0, strs.length-1);//这里是右边的字符

        
        }
        private String LongestCommonPrefix(String[] strs,int l,int r){
            
            if(l==r){
                return strs[l];
            }else{
                int mid = (l+r)/2;
                String left = LongestCommonPrefix(strs, l, mid);
                String right = LongestCommonPrefix(strs, mid+1, r);
                return commonPrefix(left, right);
            }

            
                
        }
        public String commonPrefix(String left,String right) {
            int min = Math.min(left.length(), right.length());
            for(int i = 0;i<min;i++){
                if(left.charAt(i)!=right.charAt(i)){
                    return left.substring(0,i);
                }
            }
            return left.substring(0,min);
        }
            
    
}
// @lc code=end

