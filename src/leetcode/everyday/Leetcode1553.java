package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/12
 *@Time: 15:40
 * 厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子：

吃掉一个橘子。
如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
每天你只能从以上 3 种方案中选择一种方案。

请你返回吃掉所有 n 个橘子的最少天数。
 */

import java.util.HashMap;

public class Leetcode1553 {
    public static void main(String[] args) {

    }
    //记忆化搜索
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int minDays(int n) {
        if(n <= 1) return n;
        Integer res = map.get(n);       //记忆化搜索，如果存在，就不用再找了
        if(res != null) return res;
        res =  Math.min(minDays(n/2) + n % 2, minDays(n/3) + n % 3) + 1;
        map.put(n, res);
        return res;
    }
}
