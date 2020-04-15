/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 记得这个题应该是做过的，跟陈思为讲过的 两个有序数组的排序是归并排序，今天把归并排序理解一下。 如何把两个数组合并为一个数组呢？
         
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        // 判断边界条件
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }
        // 如何把两个数组进行合并,这两个数组根据归并排序赢不用合并啊
        // 用一个count进行计数.这里是归并排序的思路
        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];// 里面进行更新i
            } else {
                nums[count++] = nums2[j++];
            }
        }
        if (count % 2 == 0) {// 说明是偶数
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }*/
        /**
         * 方法2，找到k值来进行确定
         * 把奇数偶数情况进行合并了
         */
        int m = nums1.length;
        int n = nums2.length;
        int left = (m+n+1)/2;
        int right = (m+n+2)/2;
        //把奇数和偶数的情况合并，如果为奇数，会求两次相同的k
        return (getKth(nums1, 0, m-1, nums2, 0, n-1, left)+getKth(nums1, 0, m-1, nums2, 0, n-1, right))*0.5;
    }
    //这个方法是为了求第几个k值在哪里，这里还是需要用递归进行解题呢
    private int getKth(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1 = end1-start1+1;
        int len2 = end2-start2+1;
        //len1的长度少于len2，这样保证有数组空了，一定在len2上
        if (len1>len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);//这里似乎只是吧位置换了个顺序
        }
        if (len1==0) {
            return nums2[start2+k-1];//这里是为啥子，先圈出来撒
        }
        if (k==1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //接下来定义这两个i，j又是干啥的，移动的位置在哪里
        int i = start1+Math.min(len1, k/2)-1;
        int j = start2+Math.min(len2, k/2)-1;
        if (nums1[i]>nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j+1, end2, k-(j-start2+1));//k值为第几小的数字
        }else{
            return getKth(nums1, i+1, end1, nums2, start2, end2, k-(i-start1+1));
        }
        
    }
}
// @lc code=end
