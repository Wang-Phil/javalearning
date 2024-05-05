package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/1
 *@Time: 9:41
 * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。

同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：

总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
一位工人只能被选择一次。
返回雇佣恰好 k 位工人的总代价。
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode2462 {
    public static void main(String[] args) {
        System.out.println(totalCost(new int[]{1,2,4,1}, 3, 4));
    }
//题目理解：candidate用来规定选择的范围，k用来规定选择的人的个数，costs是用来选择的数组
    public static long totalCost(int[] costs, int k, int candidates) {
        //优先队列，不需要考虑下标。
        //优先队列，堆顶存储最小值
        long ans = 0;
        int n = costs.length;
        //排除一个特殊情况，如果candidate*2+k>n，肯定可以选到最小的n个数
        if(candidates * 2 + k > n){
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }
            return ans;
        }
        //接下来就是普通情况，前后两个堆，然后不断的出来和进去
        PriorityQueue<Integer> front = new PriorityQueue<Integer>((a, b) -> a - b);
        PriorityQueue<Integer> end = new PriorityQueue<>((a,b) -> a - b);
        for (int i = 0; i < candidates; i++) {
            front.offer(costs[i]);
            end.offer(costs[n-i-1]);
        }
        //然后取值
        int frontIndex = candidates;
        int endIndex = costs.length - candidates - 1;
        while(k > 0){
            if(front.peek() <= end.peek()){
                int temp = front.poll();
                ans += temp;
                front.offer(costs[frontIndex++]);
            }
            else{
                int temp = end.poll();
                ans += temp;
                end.offer(costs[endIndex--]);
            }
            k--;
        }
        return ans;
    }
}
