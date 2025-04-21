package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/2
 *@Time: 11:32
 * 给你一个整数数组 nums。

返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。
* 1 <= nums.length <= 3 * 105
1 <= nums[i] <= 100
输入保证 nums 中至少有一个质数。
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Leetcode3115 {
    public static void main(String[] args) {

    }
    //质数的最大距离
    public int maximumPrimeDifference(int[] nums) {
        Set<Integer> map = new HashSet<>();
        //先添加质数表
        for (int i = 2; i <= 100; i++) {
            if(isPrime(i)){
                map.add(i);
            }
        }
        //然后判断质数是否在
        int min = 0;
        int max = 0;
        int flag = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.contains(nums[i])){
                if(flag == 0){
                    flag = 1;
                    min = i;
                    max = i;
                }else{
                    max = i;
                }
            }
        }
        return max - min;
    }

    private boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i < num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
