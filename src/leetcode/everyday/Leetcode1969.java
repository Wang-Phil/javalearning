package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个正整数 p 。你有一个下标从 1 开始的数组 nums ，这个数组包含范围 [1, 2p - 1] 内所有整数的二进制形式（两端都 包含）。你可以进行以下操作 任意 次：
 *
 * 从 nums 中选择两个元素 x 和 y  。
 * 选择 x 中的一位与 y 对应位置的位交换。对应位置指的是两个整数 相同位置 的二进制位。
 * 比方说，如果 x = 1101 且 y = 0011 ，交换右边数起第 2 位后，我们得到 x = 1111 和 y = 0001 。
 *
 * 请你算出进行以上操作 任意次 以后，nums 能得到的 最小非零 乘积。将乘积对 109 + 7 取余 后返回。
 *
 * 注意：答案应为取余 之前 的最小值。
 *
 *
 */
public class Leetcode1969 {
    public  static  int mod = 1000000007;
    public static void main(String[] args) {
        System.out.println(minNonZeroProduct(3));
    }
    public static int minNonZeroProduct(int p) {
        //数学，找规律,然后使用矩阵快速幂惊醒求解
        long ans = divide(2,p)-1;
        long mid = (long)1 << (p-1);
        long mid2 = divide(ans - 1, mid - 1);
        ans = (ans % mod * mid2 % mod) % mod;
        return (int) ans;
    }

    //矩阵快速幂求解
    public static long divide(long a, long b){
        if(b == 0) return 1;
        if(b % 2 == 0) return divide(a % mod * a % mod, b/2) %mod;
        else return a % mod * divide(a % mod * a % mod, (b-1)/2) %mod;
    }
}
