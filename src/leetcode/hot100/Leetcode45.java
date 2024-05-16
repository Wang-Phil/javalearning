package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/16
 *@Time: 9:35
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

0 <= j <= nums[i]
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */

public class Leetcode45 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
    //跳跃游戏2
    public static int jump(int[] nums) {
        //贪心算法
        int n = nums.length;
        int border = 0;
        int maxPosition = 0;
        int count = 0;
        //在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的masPos一定大于等于最后一个位置，
        // 否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为maxPos位置的情况下，
        // 我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素。
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(i == border){                //到达边界了，对新的边界进行更新，然后必须要跳了
                border = maxPosition;
                count++;
            }
        }
        return count;
    }
}
