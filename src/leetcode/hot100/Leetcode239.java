package leetcode.hot100;

import java.util.*;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值
 */
public class Leetcode239 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
/*    public static int[] maxSlidingWindow(int[] nums, int k) {
        //滑动窗口最大值，滑动窗口简单，但是怎么求最大值
        //思路：优先队列+滑动窗口（堆+滑动窗口，堆可以自动保存最大值，最小值）时间复杂度为nlogn
        //优先队列存储的不是单列的值，而是值和对应的下标值，因为你判断的逻辑是根据堆顶元素来的。
        int n = nums.length;
        int ans[] = new int[n - k + 1];     //n-k+1为返回数组的长度
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        //先将前k个数放到堆当中
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        //遍历数组，从堆中不断抛出不符合的数据，抛出的依据就是堆顶元素当中的下标值是否满足在滑动窗口当中
        for(int i = k; i < n; i++){
            ans[i-k] = queue.peek()[0];
            queue.offer(new int[]{nums[i], i});
            while(queue.peek()[1] < (i - k + 1)){
                queue.poll();
            }
        }
        //设置最后一个元素
        ans[n-k] = queue.peek()[0];
        return ans;
    }*/

    public static int[] maxSlidingWindow(int[] nums, int k) {
        //采用单调队列的方式可以简化时间复杂度
        int n = nums.length;
        //创建双端队列
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int ans[] = new int[n - k + 1];     //n-k+1为返回数组的长度
        //在未形成窗口的时候
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        ans[0] = deque.peekFirst();
        //形成窗口后
        for (int i = k; i < nums.length; i++) {
            if(deque.peekFirst() == nums[i-k]){
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            ans[i-k+1] = deque.peekFirst();
        }
        return ans;
    }

}
