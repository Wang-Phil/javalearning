package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/23
 *@Time: 10:07
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。

在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。

当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。

书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。

请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 */

public class Leetcode1052 {
    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }

/*    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        int max_saved = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {//先统计不抑制的情况下，可以有多少个客户满意
                ans += customers[i];
            }
        }
        //然后滑动窗口统计可以实现的最大客户满意度
        for(int i = 0; i <= customers.length - minutes; i++){
            int k = 0;
            int temp_max = 0;
            while(k < minutes){
                if(grumpy[k+i] == 1){
                    temp_max += customers[k+i];
                }
                k++;
            }
            max_saved  = Math.max(max_saved, temp_max);
        }
        ans += max_saved;
        return ans;
    }*/

    //滑动窗口思路的改进
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        int max_saved = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {//先统计不抑制的情况下，可以有多少个客户满意
                ans += customers[i];
                customers[i] = 0;       //将其置为0，方便后续的计算
            }
        }
        //然后滑动窗口统计可以实现的最大客户满意度
        int temp_max = 0;
        for(int i = 0; i < customers.length; i++){
            temp_max += customers[i];
            if(i >= minutes){  //   不需要两重for循环，一个循环也能解决。
                temp_max -= customers[i-minutes];
            }
            max_saved = Math.max(max_saved, temp_max);
        }
        ans += max_saved;
        return ans;
    }
}
