package leetcode.competition406;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/14
 *@Time: 10:46
 * 有一个 m x n 大小的矩形蛋糕，需要切成 1 x 1 的小块。

给你整数 m ，n 和两个数组：

horizontalCut 的大小为 m - 1 ，其中 horizontalCut[i] 表示沿着水平线 i 切蛋糕的开销。
verticalCut 的大小为 n - 1 ，其中 verticalCut[j] 表示沿着垂直线 j 切蛋糕的开销。
一次操作中，你可以选择任意不是 1 x 1 大小的矩形蛋糕并执行以下操作之一：

沿着水平线 i 切开蛋糕，开销为 horizontalCut[i] 。
沿着垂直线 j 切开蛋糕，开销为 verticalCut[j] 。
每次操作后，这块蛋糕都被切成两个独立的小蛋糕。

每次操作的开销都为最开始对应切割线的开销，并且不会改变。

请你返回将蛋糕全部切成 1 x 1 的蛋糕块的 最小 总开销。
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leetcode100361 {
    public static void main(String[] args) {
        int m1 = 2;
        int n1 = 2;
        int[] horizontalCut1 = {7};
        int[] verticalCut1 = {4};
        System.out.println(minimumCost(m1, n1, horizontalCut1, verticalCut1));  // 输出：13
    }
    public static int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        // 创建一个存储切割线和类型的列表
        List<int[]> cuts = new ArrayList<>();
        for (int cost : horizontalCut) {
            cuts.add(new int[]{cost, 0}); // 0 代表水平切割线
        }
        for (int cost : verticalCut) {
            cuts.add(new int[]{cost, 1}); // 1 代表垂直切割线
        }

        // 按照切割开销排序
        cuts.sort(((a,b)->(b[0]-a[0])));

        int totalCost = 0;
        int hCuts = 0;
        int vCuts = 0;

        // 遍历所有切割线
        for (int[] cut : cuts) {
            int cost = cut[0];
            int type = cut[1];
            if (type == 0) { // 水平切割线
                totalCost += cost * (vCuts + 1);
                hCuts++;
            } else { // 垂直切割线
                totalCost += cost * (hCuts + 1);
                vCuts++;
            }
        }

        return totalCost;
    }
}
