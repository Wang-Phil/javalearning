package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/3
 *@Time: 10:35
 * 给你一个整数数组 arr 。

将 arr 分割成若干 块 ，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。

返回能将数组分成的最多块数？
 */

public class Leetcode768 {
    public static void main(String[] args) {}
    //最多能完成排序的块2
    public int maxChunksToSorted(int[] arr) {
        //维护右边界
        int n = arr.length;
        int right = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, arr[i]);
            if(i == right){
                ans++;
            }
        }
        return ans;
    }
}
