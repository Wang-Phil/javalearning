package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个正整数 n ，开始时，它放在桌面上。在 109 天内，每天都要执行下述步骤：
 * 对于出现在桌面上的每个数字 x ，找出符合 1 <= i <= n 且满足 x % i == 1 的所有数字 i 。
 * 然后，将这些数字放在桌面上。
 * 返回在 109 天之后，出现在桌面上的 不同 整数的数目。
 */
public class Leetcode2549 {
    public static void main(String[] args) {
        System.out.println(distinctIntegers(50));
    }
    public static int distinctIntegers(int n) {
        return n == 1 ? 1 : n - 1;
    }
}
