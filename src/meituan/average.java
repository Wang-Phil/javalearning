package meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class average {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] ans = new int[num];
        for(int i = 0; i < num; i++){
            ans[i] = in.nextInt();
        }
        Arrays.sort(ans);
        int maxlen = 1;
        int cnt = 1;
        for(int i = 0; i < num - 1; i++){
            if(ans[i] == ans[i+1]){
                cnt++;
            }else{
                cnt = 1;
            }
            maxlen = Math.max(maxlen, cnt);
        }
        System.out.println(num - maxlen);
    }
}
