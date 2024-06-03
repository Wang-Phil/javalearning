package leetcode.competition400;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/2
 *@Time: 11:04
 * 给你一个字符串 s，模拟每秒钟的事件 i：

如果 s[i] == 'E'，表示有一位顾客进入候诊室并占用一把椅子。
如果 s[i] == 'L'，表示有一位顾客离开候诊室，从而释放一把椅子。
返回保证每位进入候诊室的顾客都能有椅子坐的 最少 椅子数，假设候诊室最初是 空的
 */

public class Leetcode100307 {
    public static void main(String[] args) {
        System.out.println(minimumChairs("ELELEELEE"));
    }
    //候诊室中的最少椅子数
    public static int minimumChairs(String s) {
        char[] str = s.toCharArray();
        int cnt = 0;
        int cntE = 0;
        int cntL = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'E') {
                cntE++;
            }else if (str[i] == 'L') {
                cntL++;
            }
            cnt = Math.max(cnt, cntE - cntL);
        }
        return cnt;
    }
}
