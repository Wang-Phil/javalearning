package matiji.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/13
 *@Time: 21:14
 */

import java.util.Scanner;

public class MC0323 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // code here
        String s = input.next();
        s = s.replace("*"," ").replace("=", "");
        String[] words = s.split(" ");
        System.out.println(Integer.parseInt(words[0]) * Integer.parseInt(words[1]));
        input.close();
    }
}
