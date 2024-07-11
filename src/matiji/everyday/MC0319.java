package matiji.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/10
 *@Time: 16:11
 * 数字
2
2 是小码哥的幸运数字，小码哥认为他从出生开始算的天数中凡是带
2
2 的一定是他的幸运日，现在给出两个数字
𝐿
L 和
𝑅
R ，即从他出生开始算的第
𝐿
L 天到 第
𝑅
R 天，请求出区间
[
𝐿
,
𝑅
]
[L,R] 的所有天数幸运值之和。

对于幸运值的定义：
2
2 出现的次数之和。

比如给定区间 [2, 22]，数字2在数2中出现了1次，在数12中出现1次，在数20中出现1次，在数21中出现1次，在数22中出现2次，所以数字2在该区间内一共出现了6次，也就是说该区间的幸运值之和为6。
 */

import java.util.Scanner;

public class MC0319 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //小码哥幸运日
        int left = input.nextInt();
        int right = input.nextInt();
        long sum = 0;
        for (int i = left; i <= right; i++) {
            sum += count_2(i);
        }
        System.out.println(sum);
        input.close();
    }

    private static int count_2(int n) {
        int count = 0;
        while(n != 0){
            int m = n % 10;
            if(m == 2) count++;
            n = n / 10;
        }
        return count;
    }
}
