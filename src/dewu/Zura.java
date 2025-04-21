package dewu;

import java.util.Scanner;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Zura {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String ans[] = str.split("zura");
        System.out.println(ans.length);
    }
}
