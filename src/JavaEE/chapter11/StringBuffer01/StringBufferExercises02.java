package JavaEE.chapter11.StringBuffer01;

import java.util.Scanner;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class StringBufferExercises02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String price = "123456213.78";
        StringBuffer stringBuffer = new StringBuffer(price);
        //首先找到小数点，找到其前三位插入
        int index = stringBuffer.indexOf(".");
        for (int i = index - 3; i > 0; i-=3) {
            stringBuffer = stringBuffer.insert(i, ",");
        }
        System.out.println(stringBuffer);
    }
}
