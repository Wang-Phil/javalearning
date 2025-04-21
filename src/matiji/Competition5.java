package matiji;

import java.util.Scanner;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Competition5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // code here
        int n = input.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        //
        int m = input.nextInt();
        while(m-- > 0){
            int judge = input.nextInt();
            if(judge == 2){
                int index = input.nextInt();
                nums[index-1] = input.nextInt();
            }else if(judge == 1){
                int left = input.nextInt();
                int right = input.nextInt();
                int sum = 1;
                for(int j = left; j <= right; j++){
                    sum *= nums[j-1];
                }
                System.out.println(cal(sum));
            }
        }

        input.close();
    }

    private static int cal(int num){
        int mod = 1000000007;
        long ans = num + 1;
        for(int i = 2; i <= num / 2; i++){
            if(num % i == 0){
                ans = (ans + num % i + i) % mod;
            }
        }
        return (int)ans;
    }
}
