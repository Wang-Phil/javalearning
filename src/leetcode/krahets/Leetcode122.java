package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/2
 *@Time: 14:03
 */

public class Leetcode122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    //买卖股票的最佳时机2
    public static int maxProfit(int[] prices) {
        //贪心
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            else{
                maxProfit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
