package leetcode.competiton401;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/9
 *@Time: 10:54
 * 给你一个整数数组 rewardValues，长度为 n，代表奖励的值。

最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：

从区间 [0, n - 1] 中选择一个 未标记 的下标 i。
如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + rewardValues[i]），并 标记 下标 i。
以整数形式返回执行最优操作能够获得的 最大 总奖励。
 */

import java.math.BigInteger;
import java.util.Arrays;

public class Leetcode100319 {
    public static void main(String[] args) {
        System.out.println(maxTotalReward(new int[]{1,6,4,3,2}));
    }
        // 对 rewardValues 进行升序排序
        public static int maxTotalReward(int[] rewardValues) {
            BigInteger f = BigInteger.ONE;
            for (int v : Arrays.stream(rewardValues).distinct().sorted().toArray()) {
                BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE);
                f = f.or(f.and(mask).shiftLeft(v));
            }
            return f.bitLength() - 1;
        }
}
