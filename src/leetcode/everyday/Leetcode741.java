package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/6
 *@Time: 9:36
 * 给你一个 n x n 的网格 grid ，代表一块樱桃地，每个格子由以下三种数字的一种来表示：

0 表示这个格子是空的，所以你可以穿过它。
1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
-1 表示这个格子里有荆棘，挡着你的路。
请你统计并返回：在遵守下列规则的情况下，能摘到的最多樱桃数：

从位置 (0, 0) 出发，最后到达 (n - 1, n - 1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为 0 或者 1 的格子）；
当到达 (n - 1, n - 1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为 0 ）；
如果在 (0, 0) 和 (n - 1, n - 1) 之间不存在一条可经过的路径，则无法摘到任何一个樱桃。
 */

public class Leetcode741 {
    public static void main(String[] args) {

    }
    //困难题，三维的动态规划
    //思路：假设两个点同时从（0,0)出发走到（n,n)
    static int N = 55, INF = Integer.MIN_VALUE;
    //动态规划状态定义：总共走了k步，第一个点，走了i1行，第二个走了i2行
    static int[][][] dp = new int[2*N][N][N];
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        //初始化状态数组，都为最小值
        for(int k = 0; k < 2*N; k++) {
            for(int i1 = 0; i1 < N; i1++) {
                for(int i2 = 0; i2 < N; i2++) {
                    dp[k][i1][i2] = INF;
                }
            }
        }
        //定义起始的节点状态
        dp[2][1][1] = grid[0][0];
        for(int k = 3; k <= 2*n; k++) {
            for(int i1 = 1; i1 <= n; i1++) {
                for(int i2 = 1; i2 <= n; i2++) {
                    int j1 = k - i1, j2 = k - i2;       //得到纵坐标
                    if(j1 <= 0 || j1 > n || j2 <= 0 || j2 > n) continue;        //数组下标越界，继续下一次的遍历
                    int A = grid[i1 - 1][j1 - 1], B = grid[i2 - 1][j2 - 1];     //得到两个点所处的状态
                    if(A == -1 || B == -1) continue;                            //如果存在过不了的点，跳过
                    int a = dp[k-1][i1 - 1][i2];
                    int b = dp[k-1][i1 - 1][i2 - 1];
                    int c = dp[k-1][i1][i2 - 1];
                    int d = dp[k-1][i1][i2];
                    int t = Math.max(Math.max(a,b), Math.max(c,d)) + A;
                    if(i1 != i2) t += B;                                        //避免重复摘同一个
                    dp[k][i1][i2] = t;
                }
            }
        }
        return dp[2*n][n][n] <=  0 ? 0 : dp[2*n][n][n];
    }


}
