package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/9
 *@Time: 20:39
 * 给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。

两点之间的距离定义为它们的
曼哈顿距离
。

请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。
 */

import java.util.TreeMap;

public class Leetcode3102 {
    public static void main(String[] args) {

    }

    //最小化曼哈顿距离
    public int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> xs = new TreeMap<>();
        TreeMap<Integer, Integer> ys = new TreeMap<>();
        for (int[] p : points) {
            xs.merge(p[0] + p[1], 1, Integer::sum);
            ys.merge(p[1] - p[0], 1, Integer::sum);
        }

        int ans = Integer.MAX_VALUE;
        for (int[] p : points) {
            int x = p[0] + p[1];
            int y = p[1] - p[0];
            if (xs.get(x) == 1) xs.remove(x);
            else xs.merge(x, -1, Integer::sum); // 移除一个 x
            if (ys.get(y) == 1) ys.remove(y);
            else ys.merge(y, -1, Integer::sum); // 移除一个 y

            int dx = xs.lastKey() - xs.firstKey();
            int dy = ys.lastKey() - ys.firstKey();
            ans = Math.min(ans, Math.max(dx, dy));

            xs.merge(x, 1, Integer::sum);
            ys.merge(y, 1, Integer::sum);
        }
        return ans;
    }
}
