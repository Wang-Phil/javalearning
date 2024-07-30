package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/30
 *@Time: 20:55
 * 给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。
如果满足以下公式，则下标 i 是 好下标：
0 <= i < variables.length
((aibi % 10)ci) % mi == target
返回一个由 好下标 组成的数组，顺序不限 。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode2961 {
    public static void main(String[] args) {

    }
    //双模幂运算
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        //涉及矩阵快速幂取模
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < variables.length; i++) {
            int v[] = variables[i];
            if(power(power(v[0],v[1],10),v[2],v[3]) == target){
                res.add(i);
            }
        }
        return res;
    }

    private int power(int x, int n, int mod){
        int res = 1;
        while(n > 0){
            if(n%2 > 0){
                res = res*x%mod;
            }
            x = x*x%mod;
            n = n/2;
        }
        return res;
    }
}
