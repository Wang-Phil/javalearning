package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/10
 *@Time: 20:41
 * 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。

每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。

返回承载所有人所需的最小船数 。
 */

import java.util.Arrays;

public class Leetcode881 {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[] {3,5,3,4}, 3));
    }
    //救生艇
    public static int numRescueBoats(int[] people, int limit) {
        //排序+双指针
        Arrays.sort(people);
        int n = people.length;
        int res = 0;
        //查找第一个小于limit的下标
        int right = Arrays.binarySearch(people, limit);
        if(right < 0) right = -right - 2;
        else right = right - 1;
        //首先统计只能坐一个人的船的数量
        res += n - right - 1;
        //然后统计坐可能是两个人的船的数量
        int left = 0;
        while(left < right){
            if(people[left] + people[right] <= limit){
                right--;
                left++;
            }else{
                right--;
            }
            res++;
        }
        if(left == right) res++;
        return res;
    }
}
