package JavaEE.chapter13.junit;

import org.junit.jupiter.api.Test;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class JUnitMethod {
    public static void main(String[] args) {
        //传统方法
        new JUnitMethod().method1();
        new JUnitMethod().method2();
    }
    //JUnit方法，比较方便，直接加入一个@Test就可以
    @Test
    public void method1(){
        System.out.println("测试方法1");
    };
    public void method2(){
        System.out.println("测试方法2");
    };
}
