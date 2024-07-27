package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/27
 *@Time: 16:24
 */

public class Leetcode3106 {
    public static void main(String[] args) {

    }
    //满足距离约束且字典序最小的字符串
    public String getSmallestString(String s, int k) {
        char ch[] = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int dis = Math.min(ch[i]- 'a', 'z' - ch[i] + 1);
            if (dis > k) {
                ch[i] -= k;
                break;
            }
            ch[i] = 'a';
            k -= dis;
        }
        return new String(ch);
    }
}
