package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/5
 *@Time: 9:53
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
如果 k == 0 ，将第 i 个数字用 0 替换。
由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。

给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 */

import java.util.Arrays;

public class Leetcode1652 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decrypt1(new int[]{5,7,1,4},3)));
    }
    //暴力解法，时间复杂度比较高
    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int res[] = new int[n];
        //如果是0直接返回
        if(k == 0) return res;
        //k是正数
        if(k > 0){
            for (int i = 0; i < n; i++) {
                int temp = 0;
                for (int j = 1; j <= k; j++) {
                    temp +=code[(i+j)%n];
                }
                res[i] = temp;
            }
        }
        else{
            //k是负数
            for (int i = 0; i < n; i++) {
                int temp = 0;
                for (int j = -1; j >= k; j--) {
                    temp +=code[(i+j+n)%n];
                }
                res[i] = temp;
            }
        }

        return res;
    }

    //进阶算法，定长的滑动窗口
    //每次的元素选择，都可以通过加一个元素，减一个元素的值获取
    // k > 0 第一个窗口大小为【1，k+1)
    // k < 0 第一个窗口大小为[n-|k|, n)
    //假设右边界为r，合并之后的整体窗口为 [r - |k|, r)
    //k = 0 的情况可以省略
    public static int[] decrypt1(int[] code, int k) {
        int n = code.length;
        int res[] = new int[n];
        int r = k > 0 ? k +1 : n;       //确定右边界
        k = Math.abs(k);                //求绝对值
        int sum = 0;                    //每次求的元素之和
        for (int i = r - k; i < r; i++) {
            sum += code[i];             //计算第一个初始元素
        }
        for (int i = 0; i < n; i++) {
            res[i] = sum;
            sum += code[r % n];             //每次加一个元素
            sum -= code[(r -k + n) % n];    //每次减去一个元素
            r++;
        }
        return res;
    }
}
