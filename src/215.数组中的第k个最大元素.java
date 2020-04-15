import javax.swing.text.AbstractDocument.LeafElement;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==0||k==0) return 0;
        return quicksearch(nums, 0, nums.length-1, k-1);//k-1 就是数组中的序号
    }
    private int quicksearch(int[] nums,int lo,int hi,int k){
        int j = partition(nums, lo, hi);
        if(j==k) return nums[j];
        return j>k?quicksearch(nums, lo, j-1, k):quicksearch(nums, j+1, hi, k);
    }
    //快排切分，返回下标j，比nums[j] 小的都在左边，大的在其右边 我这个是从小到大排列的
    private int partition(int[] nums,int lo,int hi){ //快排的切分是左边不包括 ，右边包括啊
        int less = lo-1,more = hi;
        swap(nums, lo+(int)Math.random()*(hi-lo+1), hi);//随机切分
        while(lo<more){
            if(nums[lo]>nums[hi]){
                swap(nums, ++less, lo++);
            }else if(nums[lo]<nums[hi]){
                swap(nums, lo, --more);
            }else{
                lo++;
            }
        }
        swap(nums, more, hi);//吧切分点的值交互一下
        return more;
    }
    // public int findKthLargest(int[] nums, int k){
    //     // k是要求的第几大(从1开始计数),k-1即是数组中的序号(0开始计数)
    //     return findKthLargest(nums,0,nums.length-1,k-1);
    // }
    // public int findKthLargest(int[] nums,int low,int high,int k){
    //     int index = partition(nums,low,high,k);
    //     if (index == k)
    //         return nums[index];
    //     else if (index>k)
    //         return findKthLargest(nums,low,index-1,k);
    //     else
    //         return findKthLargest(nums,index+1,high,k);
    // }

    // // 同快排的partation,每次确定一个枢轴的位置,并返回其index
    // // 找第k 大 的数就把数组按大->小排列
    // private int partition(int[] nums,int low,int high,int k){
    //     int pivot = nums[low];

    //     while (low<high){
    //         while (low<high && nums[high]<=pivot) // nums[high]<=pivot 体现出把数组按大->小排列
    //             high--;
    //         nums[low] = nums[high];

    //         while (low< high && nums[low]>=pivot)
    //             low++;
    //         nums[high] = nums[low];//这个交换厉害了
    //     }

    //     nums[low] = pivot;
    //     return low;
    // } 


    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j] = temp;

    }
}
// @lc code=end

