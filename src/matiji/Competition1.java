package matiji;

import java.util.Scanner;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Competition1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // code here
        char str1[] = input.next().toCharArray();
        char str2[] = input.next().toCharArray();
        int j = 0;
        int i = 0;
        while(i < str1.length){
            if(str1[i] == str2[j]){
                i++;
                j++;
            }else{
                i++;
            }
            if(j == str2.length){
                System.out.println("Lucky!");
                return;
            }
        }
        System.out.println("QAQ Unlucky!");
        input.close();
    }
}
