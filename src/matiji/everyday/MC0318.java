package matiji.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/8
 *@Time: 22:21
 * 在一个由数字构成的奇幻世界里，居住着一群热爱编程和算法的生物，它们被称为“编码精灵”。这个世界被两个强大的国度所统治：奇数王国和偶数王国。奇数王国以其居民的独立和不羁著称，而偶数王国则以其和谐与平衡闻名。这两个国度之间存在着一种神秘的平衡，使得整个世界得以和平共存。

在这个世界的中心，有一座被称为“编程塔”的古老结构，它是所有编码精灵学习和挑战自我的地方。每年，编程塔都会举办一次盛大的比赛，吸引来自奇数王国和偶数王国的年轻精灵们参加。比赛的目的是解决一系列复杂的问题，以考验他们的编程技能和逻辑思维。

今年的比赛主题是“数字的和谐”，组织者提出了一个看似简单却蕴含深意的题目：“给定 n 个非负整数，请统计奇数和偶数各有多少个？”这个问题要求参赛者不仅要编写出高效的算法，还要理解数字的本质和它们之间的关系。

小码哥是一位来自奇数王国的年轻编码精灵，他因其出色的编程能力和对算法的深刻理解而闻名。他决定接受这个挑战，不仅为了证明自己的实力，也为了增进奇数王国与偶数王国之间的友谊和理解。

比赛当天，小码哥带着他的魔法键盘来到了编程塔。他深吸一口气，然后手指在键盘上飞快地舞动…
 */

import java.util.Scanner;

public class MC0318 {
    public static void main(String[] args) {

    }
}

class Main1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // code here
        int n = input.nextInt();
        int odd = 0;
        int even = 0;
        for (int i = 0; i < n; i++) {
            int num = input.nextInt();
            if (num % 2 == 0) {
                even++;
            }else{
                odd++;
            }
        }
        System.out.println(odd + " " + even);
        input.close();
    }
}