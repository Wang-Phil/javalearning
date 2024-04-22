package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/22
 *@Time: 11:37
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
只使用数字1到9
每个数字 最多使用一次
返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode216 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3,7));
    }
}
class Solution {
    //回溯算法，三个步骤，确定返回值，确定递归出口，确定每层遍历要得到什么？
    //返回值为void
    //递归出口一般决定递归的深度
    //每层递归一般采用for循环实现
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list =  new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        BackTracking(k,n,1);
        return ans;
    }
    public void BackTracking(int k, int n, int start){
        if(k == 0){
            if(n == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            BackTracking(k-1, n-i, i+1);
            list.remove(list.size()-1);
        }
    }
}