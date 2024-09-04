package leetcode.everyday;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Author: WangWeicheng
 * @Date: 2024/9/4
 * @Time: 10:59
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，其中 n 是班级中学生的总数。班主任希望能够在让所有学生保持开心的情况下选出一组学生：
 *
 * 如果能够满足下述两个条件之一，则认为第 i 位学生将会保持开心：
 *
 * 这位学生被选中，并且被选中的学生人数 严格大于 nums[i] 。
 * 这位学生没有被选中，并且被选中的学生人数 严格小于 nums[i] 。
 * 返回能够满足让所有学生保持开心的分组方法的数目。
 *
 **/
public class Leetcode2860 {
    public static void main(String[] args) {
        System.out.println(countWays(List.of(1,1)));
    }

    public static  int countWays(List<Integer> nums) {
        int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);
        int ans = arr[0] > 0 ? 1 : 0;
        for (int i = 0; i < arr.length-1; i++){
            if(arr[i] < i+1 && arr[i+1] > i+1){
                ans += 1;
            }
        }
        return ans+1;
    }
}
