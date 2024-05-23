package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/23
 *@Time: 1:41
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。

如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。

从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。

子数组 是数组中一个连续且可能为空的元素序列。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode2831 {
    public static void main(String[] args) {

    }
    //找出最长的等值子数组
    public int longestEqualSubarray(List<Integer> nums, int k) {
        //分组+滑动窗口
        int n = nums.size();
        List<Integer> res[] = new ArrayList[n+1];       //res统计每种相同的元素在数组出现的下标
        Arrays.setAll(res, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            res[x].add(i);
        }

        //然后遍历res，判断元素之间的距离是否大于k，如果大于，需要对左边界进行右移
        int ans = 0;
        for(List<Integer> pos : res){
            if(pos.size() <= ans) continue;         //如果存的个数都没有ans大，就不用进行比较了
            int left = 0;
            for(int right = 0; right < pos.size(); right++){
                while(pos.get(right) - pos.get(left) - right - left > k){
                    left++;
                }
                ans = Math.max(ans, right - left + 1);      //当前的长度
            }
        }
        return ans;
    }
}
