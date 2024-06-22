package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/22
 *@Time: 21:09
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Leetcode215 {
    public static void main(String[] args) {

    }
    //数组中第k个最大元素
    public  int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return quickSort(list, k);
    }

    //快速排序的变种
    private int quickSort(List<Integer> list, int k) {
        //划分三个list
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        List<Integer> equals = new ArrayList<>();
        Random random = new Random();
        int pivot = list.get(random.nextInt(list.size()));
        for(int num : list) {
            if(num > pivot) {
                large.add(num);
            }else if(num < pivot) {
                small.add(num);
            }else{
                equals.add(num);
            }
        }
        //判断下次递归
        if(large.size() >= k){
            return quickSort(large, k);
        }

        if(list.size() - small.size() < k){
            return quickSort(small, k - list.size() + small.size());
        }
        return pivot;
    }
}
