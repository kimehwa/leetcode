import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        //做了这么多题还是思路不清晰 ，选举算法又忘了.hash表的一些api又忘了
        //不是选举，是异或运算
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(Integer num:nums){
        //     Integer count = map.get(num);
        //     count=count==null?1:++count;
        //     map.put(num, count);
        // }
        // for(Integer i:map.keySet()){//得到hash表中的值
        //     Integer count = map.get(i);
        //     if(count==1){
        //         return i;
        //     }
        // }
        // return -1;
        int res = nums[0];
        for(int i = 1;i<nums.length;i++){
            res^=nums[i];//异或的性质，与同一个数字异或两次相当于没异或
        }
        return res;
    }
}
// @lc code=end

