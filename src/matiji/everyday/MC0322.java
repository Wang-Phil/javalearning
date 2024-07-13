package matiji.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/12
 *@Time: 10:46
 * 现在有一个长度为
𝑛
n的非严格单调递增的数组，小码哥希望你能根据他的
𝑚
m条指令来进行相应的搜索查找，你能够帮他完成吗。如果小码哥说
‘
𝐿
’
‘L’和一个数字
𝑋
X，那么请你找出这列数组中第一次出现
𝑋
X他的数组下标，如果小码哥说
‘
𝑅
’
‘R’和一个数字
𝑋
X，那么请你找出这列数组中最后一次出现这个
𝑋
X他的数组下标。如果没有这个数，请你输出‘-1’；
注意：下标从0开始！
 */

import java.util.*;

public class MC0322 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //暴力查找
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(map.containsKey(x)) {
                map.get(x).add(i);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(x,list);
            }
        }
        //超时
        while (m-- > 0) {
            int flag = 0;
            String str = sc.next();
            int num = sc.nextInt();
            if (map.containsKey(num)) {
                if(str.equals("L")){
                    System.out.println(map.get(num).get(0));
                }
                else if(str.equals("R")){
                    System.out.println(map.get(num).get(map.get(num).size()-1));
                }
            }
           else{
                System.out.println("-1");
            }
        }
        sc.close();

    }
}
