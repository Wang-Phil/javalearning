package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/13
 *@Time: 9:22
 * 给你一个长度为 n 的二维整数数组 items 和一个整数 k 。

items[i] = [profiti, categoryi]，其中 profiti 和 categoryi 分别表示第 i 个项目的利润和类别。

现定义 items 的 子序列 的 优雅度 可以用 total_profit + distinct_categories2 计算，其中 total_profit 是子序列中所有项目的利润总和，distinct_categories 是所选子序列所含的所有类别中不同类别的数量。

你的任务是从 items 所有长度为 k 的子序列中，找出 最大优雅度 。

用整数形式表示并返回 items 中所有长度恰好为 k 的子序列的最大优雅度。

注意：数组的子序列是经由原数组删除一些元素（可能不删除）而产生的新数组，且删除不改变其余元素相对顺序。
 */

import java.util.*;

public class Leetcode2813 {
    public static void main(String[] args) {

    }
    //子序列的最大优雅度
    public long findMaximumElegance(int[][] items, int k) {
        //反悔贪心，排序+堆的方式
        Arrays.sort(items, (a,b)->b[0]-a[0]);       //按照利润从大到小排
        long ans = 0;
        long totalProfit = 0;
        Set<Integer> set = new HashSet<>();
        Deque<Integer> dup = new ArrayDeque<>();        //重复类别的利润，用栈来维护
        for(int i = 0; i < items.length; i++){
            int profit = items[i][0];
            int categroy = items[i][1];
            if(i < k){
                totalProfit += profit;
                if(!set.add(categroy)){                 //如果出现重复类别，就将重复的加入到栈中
                    dup.push(profit);
                }
            //如果栈不为空，并且是之前没有的类别，需要对其pop，然后重新计算利润
            }else if(!dup.isEmpty() && set.add(categroy)){
                totalProfit += profit - dup.pop();
            }
            ans = Math.max(ans, totalProfit + (long)set.size() * set.size());
        }
        return ans;
    }
}
