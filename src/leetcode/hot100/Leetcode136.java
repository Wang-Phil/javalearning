package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/24
 *@Time: 11:15
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */

public class Leetcode136 {
    public static void main(String[] args) {

    }
    //只出现一次的数字
    public int singleNumber(int[] nums) {
        int result = 0;
        //异或操作，相同为0，不相同为1
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
