package JavaEE.chapter17.classloader;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/20
 *@Time: 15:34
 * 说明类加载的连接阶段---准备
 */

public class ClassLoad02 {
    public static void main(String[] args) {

    }
}

class A{
    //类加载阶段中连接阶段，属性如何准备
    //1、n1为实例属性，为静态变量，在准备阶段，不会分配内存
    //2、n2为静态变量，分配内存n2是默认初始化为0，而不是20
    //3、n3是static final是常量，与静态变量不一样，一旦赋值不会更改 n3 = 30
    public int n1 = 10;
    public static int n2 = 20;
    public final static int n3 = 30;
}