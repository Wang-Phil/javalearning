package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/21
 *@Time: 9:38
 * 力扣城计划在两地设立「力扣嘉年华」的分会场，气象小组正在分析两地区的气温变化趋势，对于第 i ~ (i+1) 天的气温变化趋势，将根据以下规则判断：

若第 i+1 天的气温 高于 第 i 天，为 上升 趋势
若第 i+1 天的气温 等于 第 i 天，为 平稳 趋势
若第 i+1 天的气温 低于 第 i 天，为 下降 趋势
已知 temperatureA[i] 和 temperatureB[i] 分别表示第 i 天两地区的气温。 组委会希望找到一段天数尽可能多，且两地气温变化趋势相同的时间举办嘉年华活动。请分析并返回两地气温变化趋势相同的最大连续天数。

即最大的 n，使得第 i~i+n 天之间，两地气温变化趋势相同
 */

public class Leetcode61 {
    public static void main(String[] args) {
        System.out.println(temperatureTrend(new int[]{5,10,16,-6,15,11,3}, new int[]{16,22,23,23,25,3,-16}));
    }
    //气温变化趋势
    public static int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        //变长滑动窗口
        int n = temperatureA.length;
        int changeA[] = new int[n - 1];
        int changeB[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            changeA[i] = temperatureA[i+1] - temperatureA[i] > 0 ? 1 : (temperatureA[i+1] - temperatureA[i] < 0 ? -1 : 0);
            changeB[i] = temperatureB[i+1] - temperatureB[i] > 0 ? 1 : (temperatureB[i+1] - temperatureB[i] < 0 ? -1 : 0);
        }
        int maxDay = 0;
        int left = 0, right = 0;
        while(right < n-1) {
            while(right < n -1 &&  changeA[right]  == changeB[right]) {
                right++;
                maxDay = Math.max(maxDay, right-left);
            }
            left = right;
            while(left < n -1 &&  changeA[left] != changeB[left]) {
                left++;
            }
            right = left;
        }
        return maxDay;
    }
    //第二种解法
    public static int temperatureTrend2(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int change = 0;
        int maxDay = 0;
        for (int i = 0; i < n - 1; i++) {
            if(Integer.compare(temperatureA[i+1], temperatureA[i]) == Integer.compare(temperatureB[i+1], temperatureB[i])) {
                maxDay = Math.max(maxDay, change++);
            }else{
                change = 0;
            }
        }
        return maxDay;
    }
}
