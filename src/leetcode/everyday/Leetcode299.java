package leetcode.everyday;

import java.util.HashMap;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode299 {
    public static void main(String[] args) {
        //猜数字游戏
        String string1 = "1807";
        String string2 = "7810";
        System.out.println(getHint(string1,string2));
    }

    public static String getHint(String secret, String guess) {
        int[] scount = new int[10];
        for(int i = 0; i < secret.length(); i++){
            scount[secret.charAt(i) - '0']++;
        }
        int[] gcount = new int[10];
        for(int i = 0; i < guess.length(); i++){
            gcount[guess.charAt(i) - '0']++;
        }
        int A = 0;
        int B = 0;
        for(int i = 0; i < secret.length() && i < guess.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)) A++;        //数字位置都对
        }
        for (int i = 0; i < 10; i++) {
            B  += Math.min(gcount[i],scount[i]);
        }
        B = B - A;
        return new String(A+"A"+B+"B");

    }
}
