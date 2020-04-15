import javafx.util.Pair;

/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        // 这个题又是多种情况的问题，split切分的问题是？
        // String[] nums1 = version1.split("\\.");// 切分为啥要加这个 .有个特殊的含义，需要转化字符
        // String[] nums2 = version2.split("\\.");
        // int n1 = nums1.length, n2 = nums2.length;
        // // 下面进行版本比较
        // int i1, i2;
        // for (int i = 0; i < Math.max(n1, n2); i++) {
        //     i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;// 好好记住字符串转化为整数的方法
        //     i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
        //     if (i1 != i2) {
        //         return i1 > i2 ? 1 : -1;
        //     }
        // }
        // return 0;
        // ======方法2 双指针========
        int p1 = 0,p2 =0;
        int n1 = version1.length(),n2 = version2.length();
        int i1,i2;
        Pair<Integer,Integer> pair;
        while(p1<n1||p2<n2){
            pair = getNextChunk(version1, n1, p1);
            i1 = pair.getKey();
            p1 = pair.getValue();
            pair = getNextChunk(version2, n2, p2);
            i2 = pair.getKey();
            p2 = pair.getValue();
            if(i1!=i2){
                return i1>i2?1:-1;
            }
        }
        return 0;
    }
    //三个参数，输入字符串，长度n，指针p为要检索快的第一个字符
    //在指针p和下一个点之间返回一个整数块
    public Pair<Integer,Integer> getNextChunk(String version,int n,int p){
        if(p>n-1){
            return new Pair<Integer,Integer>(0, p);
        }
        int i ,p_end =p;
        while(p_end<n&&version.charAt(p_end)!='.'){
            ++p_end;
        }
        if(p_end!=n-1){
            i = Integer.parseInt(version.substring(p,p_end));
        }else{
            i = Integer.parseInt(version.substring(p, n));
        }
        p=p_end+1;//给p重新赋值进行下一个块的进行
        return new Pair<Integer,Integer>(i,p);

    }
}
// @lc code=end
