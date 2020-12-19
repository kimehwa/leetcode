import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //  * 这个是最容易想出来的方法了，有没有什么更简单的方法呢？暴力法的时间复杂度为n2
         
        // if (nums==null||nums.length==0) {
        //     return null;
        // }   这个测试
        // for(int i= 0;i<nums.length;i++){
        //     for ( int j = i+1; j < nums.length; j++) {
        //         if(nums[i]+nums[j]==target){
        //            return new int[]{i,j}; //java的返回数组应该如何返回呢？一定要加上new啊
        //         }
        //     }
        // }
        // return null;
        /**方法二：用哈希表做，两次hash表，还可以简化到一遍的hash表
         * hash表的思路是什么呢？以及hashmap的几个api要记住
         * 
         *
        Map<Integer,Integer> hashmap = new HashMap<>();//hash表要先用map来定义啊
        for (int i = 0; i < nums.length; i++) {
            hashmap.put(nums[i], i);//这里存的人家要的是i
        }
        for (int i = 0; i < nums.length; i++) {
            int component = target -nums[i];
            if(hashmap.containsKey(component)&&hashmap.get(component)!=i){
                return new int[]{hashmap.get(component),i};
            }
        }
        throw new IllegalArgumentException("没有合适的");   */
        /**
         * 一遍hash表的思路是边存边取,这样防止了两次循环带来的速度减慢 */ 
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int component = target-nums[i];
            if(map.containsKey(component)){
                return new int[]{i,map.get(component)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("不存在");
    }
}
// @lc code=end

