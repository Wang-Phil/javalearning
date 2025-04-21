package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/2
 *@Time: 9:08
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。

医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。

给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的 最多 种类数。
 */

import java.util.HashSet;
import java.util.Set;

public class Leetcode575 {
    public static void main(String[] args) {

    }
    //分糖果
    public int distributeCandies(int[] candyType) {
        //统计糖果种类
        int n = candyType.length;
        Set<Integer> set = new HashSet<Integer>();
        for(int candy : candyType){
            set.add(candy);
        }
        return n/2 > set.size() ? set.size() : n/2;
    }
}
