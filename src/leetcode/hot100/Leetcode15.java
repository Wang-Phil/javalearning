package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class Leetcode15 {
    public static void main(String[] args) {
        //三数之和
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //排序+双指针
        Arrays.sort(nums);
        int n = nums.length;
        //第一重for循环
        for(int i = 0; i < n-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int three = n - 1;
            for(int two = i+1; two < n; two++){
                if(two > i+1 && nums[two] == nums[two - 1]) continue;
                while(two < three && nums[two] + nums[three] + nums[i] > 0) three--;
                if(two == three) break;
                if(nums[two] + nums[three] + nums[i] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[two]);
                    list.add(nums[three]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}


class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<len;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1, right=len-1;
            while(left < right){
                int sum = nums[i] + nums[left]+nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0) left++;
                else{
                    lists.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return lists;
    }
}