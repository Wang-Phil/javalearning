package leetcode.competition406;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/14
 *@Time: 10:30
 * 给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的
字典序最小的字符串
。

如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
 */

public class Leetcode100352 {
    public static void main(String[] args) {

    }
    //交换后字典序最小的字符串
    public String getSmallestString(String s) {
        //遍历即可
        char strs[] = s.toCharArray();
        for(int i = 0; i < strs.length - 1; i++){
            int num1 = (strs[i] - '0');
            int num2 = (strs[i + 1] - '0');
            if((num1 % 2 == num2 % 2)  && num1 > num2){
                char temp = strs[i];
                strs[i] = strs[i+1];
                strs[i+1] = temp;
                break;
            }
        }
        return new String(strs);
    }
}
