package leetcode.everyday;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2386 {
    public static void main(String[] args) {
        int[] nums = {1,-2,3,4,-10,12};
        int k = 16;
        System.out.println(kSum(nums, k));
    }

    public static long kSum(int[] nums, int k) {
        //先找到最大的和sum，然后再找最小k的和mink
        //sum-mink就是我们要的
        //如何找mink，对nums进行排序，每次将最小的元素加入到
        //至于负数怎么就可以变成正数，然后一起加入堆中，这个是整个算法的难点
        //如果全是正数其实还是蛮好想的
        long allSum = 0;
        int n = nums.length;
        //统计最大和，并且将负数转为正数
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0) allSum += nums[i];
            else nums[i] = -nums[i];
        }
        if(k == 1) return allSum;
        //对nums进行排序，然后选取其中第k小的元素，不断放入最小堆
        Arrays.sort(nums);
        //需要对堆进行重新改造一下，存放的数组，然后重新写一下比较函数
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a,b)->Long.compare(a[0],b[0]));  //默认为最小堆
        pq.offer(new long[]{nums[0], 0});
        int count = 1;
        long num = 0;
        while(count < k){
            long mid[] = pq.poll();
            num = mid[0];
            //i的作用就是记录当前的下标，然后方便之后加入最小堆的时候，可以减去之前的一个值
            int i = (int)mid[1];
            if(i+1 < n){
                pq.offer(new long[]{num + nums[i+1], i+1});
                pq.offer(new long[]{num - nums[i] + nums[i+1], i+1});
            }
            count++;
        }
        return allSum - num;
    }
}
