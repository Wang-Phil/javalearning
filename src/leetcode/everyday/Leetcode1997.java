package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 * 你需要访问 n 个房间，房间从 0 到 n - 1 编号。同时，每一天都有一个日期编号，从 0 开始，依天数递增。你每天都会访问一个房间。
 *
 * 最开始的第 0 天，你访问 0 号房间。给你一个长度为 n 且 下标从 0 开始 的数组 nextVisit 。在接下来的几天中，你访问房间的 次序 将根据下面的 规则 决定：
 *
 * 假设某一天，你访问 i 号房间。
 * 如果算上本次访问，访问 i 号房间的次数为 奇数 ，那么 第二天 需要访问 nextVisit[i] 所指定的房间，其中 0 <= nextVisit[i] <= i 。
 * 如果算上本次访问，访问 i 号房间的次数为 偶数 ，那么 第二天 需要访问 (i + 1) mod n 号房间。
 * 请返回你访问完所有房间的第一天的日期编号。题目数据保证总是存在这样的一天。由于答案可能很大，返回对 109 + 7 取余后的结果。
 */
public class Leetcode1997 {
    public static void main(String[] args) {
        System.out.println(firstDayBeenInAllRooms(new int[]{0,0,2}));
    }

    public static int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int rooms[] = new int[n];
        int day = 0;
        int mod = 1000000007;
        int cnt = 0;
        int i = 0;
        while(cnt < n){
            if(rooms[i] == 0) cnt++;
            rooms[i]++;
            if(rooms[i] % 2 == 1){      //如果是奇数，访问nextVisit
                i = nextVisit[i];
            }
            else{                   //如果是偶数，访问(i+1)%n
                i = (i+1)%n;
            }
            day = (day + 1) % mod;
        }
        return day-1;
    }
}
