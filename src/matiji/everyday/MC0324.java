package matiji.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/13
 *@Time: 21:21
 * 小码哥有一个无序数列，他知道插入某个数字
𝑥
x 就能使这段数据变得优美，但是这个数字必须加在合适的位置。合适的位置是指，保持原来的数列每个数的相对位置不变，将
𝑥
x插入到这个数列里第一个不小于它的数字前面。如果所有的数都比
𝑥
x小，则将
𝑥
x放到队尾。

请输出插入元素后的数列。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MC0324 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        //获取数据元素
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int i = 0;
        for(; i < n; i++){
            if(list.get(i) > num){
                break;
            }
        }

        list.add(i, num);
        for(i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        sc.close();
    }
}
