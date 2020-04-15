import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        /**
         * 原因是map取出来的是Integer类型，Integer第二次创建的时候不会使用new关键字， 而是使用已经缓存的对象。
         * 如果数值在-128~127位之间会有缓存，那么两个对象地址相同，此时使用 == 比较结果正确，
         * 如果数值超出范围，就会创建新的对象，分配的地址不同，此时再用 == 比较就会出错。 再提一句： “==”：
         * 对于基本类型来说比较的是值；对于引用类型比较的是地址。
         * 
         * 改进建议： 将 == 改为 compareTo
         */
        // 这个题其实可以用数组来表示，需要再看一下这个题吧
        if (s.length() == 0 || t.length() == 0)
            return "";
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            // if (!tmap.containsKey(s.charAt(i))) {//这里不用进行判断了，因为有getordefault了
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);// 这里的map操作
            // }
        }
        // 在写另外一个map数组，要设置一个left，right，还要动态找到这个数组，不是返回的最小值
        int required = tmap.size();// hashmap的api
        int l = 0, r = 0, formed = 0;
        HashMap<Character, Integer> smap = new HashMap<>();//
        // 如何写循环条件
        int[] ans = { -1, 0, 0 };// 分别表示窗口的长度，左右两个边界
        // for(Character c:tmap.keySet()){ //把键放在新的hash表中
        // smap.put(c,0);
        // }
        // 终止条件是left到达某一个点了？
        while (r < s.length()) {
            char c = s.charAt(r);
            int count = smap.getOrDefault(c, 0);
            smap.put(c, count + 1);
            if (tmap.containsKey(c) && smap.get(c).intValue() == tmap.get(c).intValue()) {// 这个intvalue是什么意思
                formed++; // 有一个对应的就行。。。 Integer是对象，大于小于比较的话没问题，会自动拆箱成基本类型。但
                // 是等于比较的话有些复杂，这个博客讲的不错：https://my.oschina.net/miwang/blog/730343
            }
            while (l <= r && formed == required) {// 这里的循环条件是l<=r,因为二者可以重合
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {// 每当取到更小的时候就去减1
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                // 左边动态减去1
                smap.put(c, smap.get(c) - 1);// 每次动态减1
                if (tmap.containsKey(c) && smap.get(c).intValue() < tmap.get(c).intValue()) {
                    formed--;
                }
                l++;

            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);// 这里右边取不到

    }
}
// @lc code=end
