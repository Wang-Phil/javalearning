package leetcode.everyday;

import java.util.Arrays;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。
 * 如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。
 * 返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。
 * 数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。
 */
public class Leetcode2952 {
    public static void main(String[] args) {

    }

    public static int minimumAddedCoins(int[] coins, int target) {
        int unableNum = 1;
        int i = 0;
        int ans = 0;
        Arrays.sort(coins);
        while(unableNum <= target){
            if(i < coins.length && unableNum <= coins[i]){
                unableNum += coins[i++];
            }
            else{
                unableNum*=2;
                ans++;
            }
        }
        return ans;
    }
}
