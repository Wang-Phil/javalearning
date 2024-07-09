package matiji.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/9
 *@Time: 21:10
 * 天，小码哥收到了一封神秘的信件，邀请他参加一场旅行。

这场旅行将带他穿越一个有一些传送门的古老迷宫。迷宫由
𝑛
n层组成，下标从1开始。每层都有一个传送门，这些传送门的行为由一个数字
𝑘
（
0
≤
𝑘
≤
𝑛
）
k（0≤k≤n）决定。数字
𝑘
k表示当前层可以传送的步数，既可以向上也可以向下。

小码哥的目标是从迷宫的第
𝑥
x层出发，到达第
𝑦
y层。然而，传送门的使用有一些限制：
1.如果从当前层向上或向下传送，目标层超出了迷宫的范围，则该传送无效。
2.每次传送只能按照当前层的
𝑘
k数值进行移动。
举例：假设一共7层，且2层的数字是3，那可以从2层到5层，但是无法从2层到-1层。

现在，小码哥需要知道从第
𝐴
A层到达第
𝐵
B层至少需要多少次传送。如果无法到达，则返回 -1。
 *
 */
import java.util.Scanner;
import java.util.*;

public class MC0307 {

}
//迷宫挑战
class Main2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // code here
        int n = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();
        int arr[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = input.nextInt();
        }
        //然后bfs实现
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while (!q.isEmpty()) {//一层测层比遍历
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int temp = q.poll();
                if (temp == y) {
                    System.out.println(temp);
                    return;
                }
                if(temp+arr[temp] < n && temp+arr[temp] >= 0){
                    q.add(temp+arr[temp]);
                }
                if(temp-arr[temp] < n && temp-arr[temp] >= 0){
                    q.add(temp-arr[temp]);
                }
            }
            cnt++;
        }
        System.out.println(-1);
        input.close();
    }
}