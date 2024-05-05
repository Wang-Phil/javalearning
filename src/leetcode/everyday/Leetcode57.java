package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/2
 *@Time: 11:26
 * 有 n 名工人。 给定两个数组 quality 和 wage ，其中，quality[i] 表示第 i 名工人的工作质量，其最低期望工资为 wage[i] 。
现在我们想雇佣 k 名工人组成一个工资组。在雇佣 一组 k 名工人时，我们必须按照下述规则向他们支付工资：
对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。
工资组中的每名工人至少应当得到他们的最低期望工资。
给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额 。在实际答案的 10-5 以内的答案将被接受。。
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode57 {
    public static void main(String[] args) {
        System.out.println(mincostToHireWorkers( new int[]{10,20,5}, new int[]{70,50,30}, 2));
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        //思路是贪心+优先队列，首先求得当前平均质量下的最优值，然后放入到优先队列当中，不断判断与维护，取其中的更小值
        int n = quality.length;
        //Arrays.setAll方法接受一个数组和一个lambda表达式，用于设置数组中的每个元素的值。由于lambda表达式需要返回一个Integer类型的值，所以id数组应该声明为Integer[]。
        Integer id[] = new Integer[n];
        Arrays.setAll(id, i -> i);
        //原本是wage[i]/quality[i] 与 wage[j]/quality[j]比较，由于是升序，所以是 wage[i]/quality[i] > wage[j]/quality[j],可以转换为wage[i]*quality[j] - wage[j]*quality[i]
        Arrays.sort(id,(i,j)->wage[i]*quality[j] - wage[j]*quality[i]);
        //优先队列存储当前质量之比从低到高的工人
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);        //默认是小跟堆，这里需要重写比较函数，转化为大根堆
        int sum = 0;
        //统计当前质量综合，后序就是质量总合*单位质量的薪水
        for (int i = 0; i < k; i++) {
            pq.add(quality[id[i]]);
            sum += quality[id[i]];
        }
        //选r值最小的k名工人
        double ans = sum * (double)wage[id[k-1]]/quality[id[k-1]];
        //看看后面有咩有quality较小的元素，总合可能还会变小
        for (int i = k; i < n; i++) {
            int q = quality[id[i]];
            if(q < pq.peek()){
                sum += q;
                sum -= pq.poll();
                pq.offer(q);
                ans = Math.min(ans,sum * (double)wage[id[i]]/quality[id[i]]);
            }
        }
        return ans;
    }
}
