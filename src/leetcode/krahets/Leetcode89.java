package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/6
 *@Time: 21:14
 * n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
第一个整数是 0
一个整数在序列中出现 不超过一次
每对 相邻 整数的二进制表示 恰好一位不同 ，且
第一个 和 最后一个 整数的二进制表示 恰好一位不同
给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode89 {
    public static void main(String[] args) {}
    //格雷编码
    public List<Integer> grayCode(int n) {
        //数学，解决方式
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        int head = 1;
        for (int i = 1; i <= n; i++) {
            for(int j = res.size() - 1; j >= 0; j--){
                res.add(head+res.get(j));
            }
            head <<= 1;
        }
        return res;
    }
}
