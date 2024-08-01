package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/29
 *@Time: 11:01
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。

比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：

整数 x - 表示本回合新获得分数 x
"+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
"D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
"C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
请你返回记录中所有得分的总和。
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Leetcode682 {
    public static void main(String[] args) {
        String ans[] = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(ans));
    }
    //棒球比赛
    public static int calPoints(String[] operations) {
        //栈的应用
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (String op : operations) {
            switch (op) {
                case "C":       //是c，删除最后一个
                    stack.removeLast();
                    break;
                case "D":      //是d，前一个加两倍
                    stack.add(stack.get(stack.size()-1)*2);
                    break;
                case "+":
                    int a = stack.get(stack.size()-1);
                    int b = stack.get(stack.size()-2);
                    stack.add(a+b);
                    break;
                default:
                    stack.add(Integer.parseInt(op));
                    System.out.println(stack);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.removeLast();
        }
        return sum;
    }
}
