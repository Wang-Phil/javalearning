package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/24
 *@Time: 10:11
 * 给你一个下标从 0 开始的整数数组 nums ，表示一些石块的初始位置。再给你两个长度 相等 下标从 0 开始的整数数组 moveFrom 和 moveTo 。

在 moveFrom.length 次操作内，你可以改变石块的位置。在第 i 次操作中，你将位置在 moveFrom[i] 的所有石块移到位置 moveTo[i] 。

完成这些操作后，请你按升序返回所有 有 石块的位置。

注意：

如果一个位置至少有一个石块，我们称这个位置 有 石块。
一个位置可能会有多个石块。
 */

import java.util.*;

public class Leetcode2766 {
    public static void main(String[] args) {

    }
    //重新放置石块
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set = new HashSet<Integer>();
        //先将石头位置放在set中
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //再将石块丢进去，将要移除
        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}
