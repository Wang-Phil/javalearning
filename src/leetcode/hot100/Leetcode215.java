package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/14
 *@Time: 12:09
 */

import java.util.*;

public class Leetcode215 {
    public static void main(String[] args) {
        System.out.println(findKthLargest1(new int[]{3,2,1,5,6,4}, 2));
    }
    //第一种方法
    public static int findKthLargest(int[] nums, int k) {
        //排序之后，然后取第k大
       Arrays.sort(nums);
       return nums[nums.length - k];
    }

    //第二种方法，快速排序
    public static int findKthLargest1(int[] nums, int k) {
        int ans  = 0;
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        return quickSort(list, k);
    }

    public static int quickSort(List<Integer> nums, int k) {
        //随机选择基准数字
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size()));
        List<Integer> big = new ArrayList<Integer>();
        List<Integer> euqals = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for(int num : nums) {
            if(num > pivot){
                big.add(num);
            }else if(num < pivot){
                small.add(num);
            }else{
                euqals.add(num);
            }
        }
        //第k大元素在big里面
        if(big.size() >= k){
            return quickSort(big, k);
        }
        //第k大元素在small里面
        if(nums.size() - small.size() < k){
            return quickSort(small, k - nums.size() + small.size());
        }
        return pivot;
    }


    //第三种方法，小堆顶方法
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            if(pq.size() < k){
                pq.add(num);
            }else if(pq.peek() < num){
                pq.poll();
                pq.add(num);
            }
        }
        return pq.peek();
    }
}
