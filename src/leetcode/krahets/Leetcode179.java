package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/2
 *@Time: 14:28
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。

注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数
* 输入：nums = [3,30,34,5,9]
*
输出："9534330"
 */

import java.util.Arrays;

public class Leetcode179 {
    public static void main(String[] args) {}
    //最大数
    public String largestNumber(int[] nums) {
        //思路：将其转化为字符串，然后按照字符串的字典序进行排序
        String strs[] = new String[nums.length];
        //将数字转换为字符串
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //然后排序组合,按照字典序的从大到小进行排序
        Arrays.sort(strs,(x, y) -> (y+x).compareTo(x+y));
        //如果最大的都是从0开始，那么后面的全是0
        if(strs[0].equals("0")){
            return "0";
        }
        //将字符串数组转换为一个字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}
