package matiji.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/9
 *@Time: 22:01
 * 现在，我们有八个备战席，一个备战席只能放一个战棋。同时还有一个补充战棋队列。备战席战棋确定后，会依次按顺序扫描补充队列，每次扫描一个，看是否有一个战棋能和备战席中的两个战棋发生进化反应。例如（2 2 3 3 4 4 1 1）（1）可以变成（2 2 3 3 4 4 10）。要注意，一次只扫描补充队列的中一个，例如（2 2 3 3 4 4 5 1）（1 1）不能直接合成（2 2 3 3 4 4 5 10）。

要注意备战席里，如果凑齐三个同战力的，会自动发生进化。比如（1 1 1 1 1 1 1 1）（1），会连续进化变成（100）。另外，被扫描到的补充队列的战棋，如果没有发生反应，且当前备战席没有满员，那这个战棋会进入到备战席，否则，就会直接略过去。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MC0311 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // code here
        //从键盘中获取输入
        String list[] = input.nextLine().split(" ");
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < list.length; i++) { //当前备战席
            ans.add(Integer.parseInt(list[i]));
        }
        int n = input.nextInt();            //补充的序列的长度
        int arr[] =  new int[n];
        for (int i = 0; i < n; i++) {       //补充顺序
            arr[i] = input.nextInt();
        }
        int enemy = input.nextInt();        //敌人的战力
        //模拟战棋
        int i = 0;
        while (i < n) {
            int j = i;
            if(j < n - 2 && ans.get(j) == ans.get(j + 1) && ans.get(j + 2) == ans.get(j + 1)) {
                int num = ans.get(j);
                ans.remove(j);
                ans.remove(j + 1);
                ans.remove(j + 2);
                ans.add(num * 10);
            }
            i++;
        }
        input.close();
    }
}
