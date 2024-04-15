package JavaEE.chapter10.trycatch;

import java.util.Scanner;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = 0;
        boolean flag = true;
        while(flag){
            try {
                n1 = Integer.parseInt(scanner.next());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("输入不合法，请重新输入");
            }
        }
        System.out.println("获取到合法数字"+n1);


    }
}
