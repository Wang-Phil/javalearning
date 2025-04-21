package matiji;

import java.util.Scanner;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Competition10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 获取字符串
        String str = input.next();
        int count = input.nextInt();
        while(count-- > 0){
            int left = input.nextInt();
            int right = input.nextInt();
            if((right-left+1)*3 > str.length()){
                System.out.println(-1);
                continue;
            }
            String s1 = str.substring(left-1, right);
            //先删除掉当前的字符串，匹配的
            String leave = str.substring(0,left-1) + str.substring(right);
            //然后再匹配,第一个就不存在，直接输出-1
            if(leave.contains(s1)){
                int index = leave.indexOf(s1);
                leave = leave.substring(index+s1.length());
                if(leave.contains(s1)){
                    System.out.println(1);
                }else{
                    System.out.println(-1);
                }
            }else{
                System.out.println(-1);
            }
        }
        input.close();
    }
}
