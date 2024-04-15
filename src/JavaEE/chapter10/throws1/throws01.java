package JavaEE.chapter10.throws1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class throws01 {
    public static void main(String[] args) {

    }

//    public void f2() throws FileNotFoundException{
//    public void f2() throws FileNotFoundException, NullPointerException, ArithmeticException{
    public void f2() throws Exception{
        //抛出异常，让调用f2的调用者进行处理
        //throws后面可以是当前异常的父类，也可以抛出多个异常
        FileInputStream fis = new FileInputStream("d://aa.txt");
    }
}
