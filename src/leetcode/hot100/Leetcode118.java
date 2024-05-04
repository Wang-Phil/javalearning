package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/3
 *@Time: 20:12
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

/*    public static List<List<Integer>> generate(int numRows) {
        //杨辉三角
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> ans = new ArrayList<>();
            ans.add(1);
            for (int j = 2; j < i; j++) {
                int num = temp.get(j - 2) + temp.get(j - 1);
                ans.add(num);
            }
            ans.add(1);
            temp = ans;
            res.add(ans);
        }
        return res;
    }*/

    //方法写简洁一些
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                }else{
                    row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
