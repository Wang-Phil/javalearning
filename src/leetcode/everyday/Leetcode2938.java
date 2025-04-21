package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/6
 *@Time: 9:52
 * 桌子上有 n 个球，每个球的颜色不是黑色，就是白色。
给你一个长度为 n 、下标从 0 开始的二进制字符串 s，其中 1 和 0 分别代表黑色和白色的球。
在每一步中，你可以选择两个相邻的球并交换它们。
返回「将所有黑色球都移到右侧，所有白色球都移到左侧所需的 最小步数」。
 */

public class Leetcode2938 {
    public static void main(String[] args) {

    }
    //区分黑球和白球
    public long minimumSteps(String s) {
        //0,1交换位置，统计交换的最小次数，所有的1都要移动到最右边，所有的黑色的都要移动到最左边
        //思路：在遍历的过程中维护黑色球的个数，一旦遇到白的，就需要与左边黑球个数进行交换
        int black = 0;
        long ans = 0;
        char str[] = s.toCharArray();
        for(int i = 0; i < str.length; i++){
            //先统计球的数量
            if(str[i] == '0'){
                ans += black;
            }else{
                black++;
            }
        }
        return ans;
    }
}
