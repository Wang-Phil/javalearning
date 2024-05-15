package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/11
 *@Time: 10:02
 * 给你一个下标从 0 开始的字符串数组 garbage ，其中 garbage[i] 表示第 i 个房子的垃圾集合。garbage[i] 只包含字符 'M' ，'P' 和 'G' ，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃。垃圾车收拾 一 单位的任何一种垃圾都需要花费 1 分钟。

同时给你一个下标从 0 开始的整数数组 travel ，其中 travel[i] 是垃圾车从房子 i 行驶到房子 i + 1 需要的分钟数。

城市里总共有三辆垃圾车，分别收拾三种垃圾。每辆垃圾车都从房子 0 出发，按顺序 到达每一栋房子。但它们 不是必须 到达所有的房子。

任何时刻只有 一辆 垃圾车处在使用状态。当一辆垃圾车在行驶或者收拾垃圾的时候，另外两辆车 不能 做任何事情。

请你返回收拾完所有垃圾需要花费的 最少 总分钟数。
 *
 */

import java.util.HashMap;
import java.util.HashSet;

public class Leetcode2391 {
    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[]{"G","P","GP","GG"}, new int[]{2,4,3}));
    }
    //收集垃圾的最少总时间
    public static int garbageCollection(String[] garbage, int[] travel) {
        int n = travel.length;
        int maxGIndex = 0;
        int maxPIndex = 0;
        int maxMindex = 0;
        int sum = 0;
        //分别统计字符串所有长度，然后统计每个字符在最后出现的下标
        for (int i = 0; i < garbage.length; i++) {
            char ch[] = garbage[i].toCharArray();
            sum += ch.length;
            for(char c : ch){
                if(c == 'G'){
                    maxGIndex = i;
                }
                else if(c == 'P'){
                    maxPIndex = i;
                }
                else if(c == 'M'){
                    maxMindex = i;
                }
            }
        }
        //然后进行求和
        for(int i = 0; i < maxPIndex; i++){
            sum += travel[i];
        }
        for(int i = 0; i < maxMindex; i++){
            sum += travel[i];
        }
        for(int i = 0; i < maxGIndex; i++){
            sum += travel[i];
        }
        return sum;
    }
    //倒序的hashset方法
    public static int garbageCollection1(String[] garbage, int[] travel) {
        int n = travel.length;
        int ans = garbage[0].length();
        HashSet set = new HashSet();
        for(int i = garbage.length - 1; i >= 0; i--){
            char str[] = garbage[i].toCharArray();
            for(char c : str){
                set.add(c);
            }
            ans += str.length + travel[i-1] * set.size();
        }
        return ans;
    }
}
