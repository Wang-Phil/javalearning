package leetcode.competiton401;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/9
 *@Time: 10:47
 * 给你两个整数 n 和 k。

最初，你有一个长度为 n 的整数数组 a，对所有 0 <= i <= n - 1，都有 a[i] = 1 。每过一秒，你会同时更新每个元素为其前面所有元素的和加上该元素本身。例如，一秒后，a[0] 保持不变，a[1] 变为 a[0] + a[1]，a[2] 变为 a[0] + a[1] + a[2]，以此类推。

返回 k 秒后 a[n - 1] 的值。

由于答案可能非常大，返回其对 109 + 7 取余 后的结果。
 */

import java.util.Arrays;

public class Leetcode100305 {
    public static void main(String[] args) {
        System.out.println(valueAfterKSeconds(5,3));
    }
    //k秒后的第n个元素
    public static int valueAfterKSeconds(int n, int k) {
        //前缀和
        long nums[] = new long[n];
        long prev[] = new long[n];
        Arrays.fill(nums, 1);
        Arrays.fill(prev, 1);
        for (int i = 1; i <= k; i++) {
            for(int j = 1; j < n; j++) {
                nums[j] = (prev[j] + nums[j - 1]) % 1000000007;
            }
            prev = nums;
        }
        return (int)nums[n-1];
    }
}
