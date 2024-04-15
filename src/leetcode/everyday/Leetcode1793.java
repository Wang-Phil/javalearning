package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
 *
 * 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
 *
 * 请你返回 好 子数组的最大可能 分数 。
 */
public class Leetcode1793 {
    public static void main(String[] args) {
        //中心向两边扩散
        int nums[] = {1,4,3,7,4,5};
        int k = 3;
        System.out.println(maximumScore(nums, k));
    }

    public static int maximumScore(int[] nums, int k) {
        int ans = nums[k];
        int n = nums.length;
        int left = k;
        int right = k;
        int min = nums[k];
        while(left >= 0 || right < n){
            //贪心扩大区间
            while(left >= 0 && nums[left] >= min){
                left--;
            }
            while(right < n && nums[right] >= min){
                right++;
            }
            ans = Math.max(ans, min*(right-left-1));    //计算当前的最小
            //更新最小值
            if(left >= 0 && right < n) {
                //只对min进行一次更新，因为要计算所有的min，这里先计算较大的min
                min = Math.max(nums[left], nums[right]);
            }else if(left >= 0){
                min = Math.min(nums[left],min);
            }else if(right < n){
                min = Math.min(nums[right],min);
            }
        }
        return ans;
    }
}

