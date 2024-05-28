package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/28
 *@Time: 9:57
 * 给你一个下标从 0 开始的数组 mountain 。你的任务是找出数组 mountain 中的所有 峰值。
以数组形式返回给定数组中 峰值 的下标，顺序不限 。
注意：
峰值 是指一个严格大于其相邻元素的元素。
数组的第一个和最后一个元素 不 是峰值。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode2951 {
    public static void main(String[] args) {

    }
    //找出峰值
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                list.add(i);
            }
        }
        return list;
    }
}
