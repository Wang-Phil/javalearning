package leetcode.everyday;
/*
 *Author: [WangWeicheng]
 *Date: 2024/4/19
 *Time: 上午10:36
 */

public class Leetcode1883 {
    public static void main(String[] args) {
        System.out.println(minSkips(new int[]{7,3,5,5},2, 10 ));
    }
/*    public static int minSkips(int[] dist, int speed, int hoursBefore) {
        //采用动态规划的思路来进行判断，如何思考呢，在灵山大佬的笔记中说，有两种思路：一种【选与不选】，一种是【选哪一个】
        //动态规划转移方程：dp[i][j]表示，最多跳过i次，从0到j的最小时间。但是因为涉及到浮点数运算，改成了最小的距离
        //这里采用的是选还是不选，dp[i][j] = Math.min(dp[i-1][j-1]+dist[j]/speed+(dp[i][j-1]+dist[i]/speed)向上取整））
        //初始化的话，是在不跳过的情况下，直接加上一个if判断条件进行
        //可以对其进行空间复杂度上的改进
        int sumDist = 0;
        for(int x : dist){
            sumDist += x;
        }
        if(sumDist > (long)speed*hoursBefore) return -1;

        int n = dist.length;
        int dp[][] = new int[n][n];
        for(int i=0; ; i++){
            for(int j=0; j<n-1; j++){
                dp[i][j+1] = (dp[i][j] + dist[j] + speed - 1) / speed * speed;
                if(i > 0){
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i-1][j] + dist[j]);
                }
            }
            if(dp[i][n-1] + dist[n-1] <= (long)speed*hoursBefore) return i;
        }
    }*/
public static int minSkips(int[] dist, int speed, int hoursBefore) {
    //采用动态规划的思路来进行判断，如何思考呢，在灵山大佬的笔记中说，有两种思路：一种【选与不选】，一种是【选哪一个】
    //动态规划转移方程：dp[i][j]表示，最多跳过i次，从0到j的最小时间。但是因为涉及到浮点数运算，改成了最小的距离
    //这里采用的是选还是不选，dp[i][j] = Math.min(dp[i-1][j-1]+dist[j]/speed+(dp[i][j-1]+dist[i]/speed)向上取整））
    //初始化的话，是在不跳过的情况下，直接加上一个if判断条件进行
    //可以对其进行空间复杂度上的改进
    int sumDist = 0;
    for(int x : dist){
        sumDist += x;
    }
    if(sumDist > (long)speed*hoursBefore) return -1;

    int n = dist.length;
    int dp[] = new int[n];

    for(int i=0; ; i++){
        int pre = 0;
        for(int j=0; j<n-1; j++){
            int temp = dp[j+1];
            dp[j+1] = (dp[j] + dist[j] + speed - 1) / speed * speed;
            if(i > 0){
                dp[j+1] = Math.min(dp[j+1], pre + dist[j]);
            }
            pre = temp;
        }
        if(dp[n-1] + dist[n-1] <= (long)speed*hoursBefore) return i;
    }
}
}
