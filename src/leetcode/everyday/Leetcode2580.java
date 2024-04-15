package leetcode.everyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个二维整数数组 ranges ，其中 ranges[i] = [starti, endi] 表示 starti 到 endi 之间（包括二者）的所有整数都包含在第 i 个区间中。
 * 你需要将 ranges 分成 两个 组（可以为空），满足：
 * 每个区间只属于一个组。
 * 两个有 交集 的区间必须在 同一个 组内。
 * 如果两个区间有至少 一个 公共整数，那么这两个区间是 有交集 的。
 * 比方说，区间 [1, 3] 和 [2, 5] 有交集，因为 2 和 3 在两个区间中都被包含。
 * 请你返回将 ranges 划分成两个组的 总方案数 。由于答案可能很大，将它对 109 + 7 取余 后返回。
 */
public class Leetcode2580 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        int ranges[][] = new int[][]{{1, 3}, {10, 20}, {2, 5}, {4, 8}};
        System.out.println(countWays(ranges));
    }

    public static int countWays(int[][] ranges) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int n = ranges.length;
        int count = 1, i = 0;
        while(i < n-1){
            int maxNum = ranges[i][1];
            while(i < n-1 && maxNum >= ranges[i+1][0]){
                maxNum = Math.max(maxNum, ranges[i+1][1]);
                i++;
            }
            count++;
            i++;
        }
        //最后求解，2 ^ (n-count)
        return (int) quick(2, count);
    }
    public static long quick(long num, long n){
        if(n == 1) return num;
        if(n % 2 == 1) return (quick(num, n / 2) % mod * quick(num, (n+1) /2) % mod) % mod;
        else  return (quick(num, n / 2) % mod * quick(num, n /2) % mod) % mod;
    }
}
