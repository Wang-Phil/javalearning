/**
 * @version 1.0
 * @Author: WangWeicheng
 * @Date: 2024/9/16
 * @Time: 9:00
 *
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 **/
public class Leetcode1184 {
    public static void main(String[] args) {
        System.out.println(distanceBetweenBusStops(new int[]{1,2,3,4}, 0, 3));
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start > destination){
            int temp = start;
            start = destination;
            destination = temp;
        }
        int minLen1 = 0;
        int minLen2 = 0;
        for(int i = 0; i < distance.length; i++){
            if(i >= start && i < destination){
                minLen1 += distance[i];
            }else{
                minLen2 += distance[i];
            }
        }
        return Math.min(minLen1, minLen2);
    }
}
