package matiji.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/11
 *@Time: 15:35
 * 数学上把2的x次方叫2的x次幂，如4、8、16等，而小码哥定义了一个数字的亲近数：距离最近的那个2的幂。

对于数字
𝑛
n ，请找出他的亲近数。

注意如果有两个距离相同，输出小的数。
 */

import java.util.Scanner;

public class MC0321 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // code here
        int n = input.nextInt();
        int cnt = 0;
        int temp = n;
        while(temp > 0){
            cnt++;
            temp /= 2;
        }
        long small = (long) Math.pow(2, cnt-1);
        long big = (long) Math.pow(2, cnt);
        if(n - small <= big - n){
            System.out.println(small);
        }else{
            System.out.println(big);
        }
        input.close();
    }
}
