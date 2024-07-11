package matiji.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/11
 *@Time: 10:25
 * 对一个字符串
S ，有以下两种操作：
• 将子串 01 替换为 1
• 将子串 10 替换为 0
总共
t组数据，每组的
S都是一个给定长度为
𝑛
n的 01 串。
求每组数据中，
S一共有多少个子串，能经过若干次操作，变成长度为1的字符串。
 */

import java.util.Scanner;

public class MC0320 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //采用容斥原理，首先计算所有子串数目，然后排出不符合的个数。遍历子串，只要最后面的两个字符串不相同，就可以排出
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            long sum = 0;
            int len = input.nextInt();
            String s = input.next();
            sum = 0;
            for(int j = 0; j < len; j++){
                if(j > 0 && s.charAt(j - 1) != s.charAt(j)){
                    sum += j+1;
                }else{
                    sum+=1;
                }
            }
            System.out.println(sum);
        }
        input.close();
    }
}
