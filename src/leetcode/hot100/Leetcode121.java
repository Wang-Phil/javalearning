package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/15
 *@Time: 9:58
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0。
 */

public class Leetcode121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int x : prices){
            min = Math.min(min, x);
            res = Math.max(res, x-min);
        }
        return res;
    }
}
