package JavaEE.chapter11.system;

import java.util.Arrays;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class SystemMethod {
    public static void main(String[] args) {
        //1、exit 退出当前程序
        System.exit(0);
        System.out.println("程序退出了吗");
        //2、arraycopy,复制数组
        int[] src = {1,2,3};
        int[] des = new int[5];
        //各个参数解释，第一个参数为原来的数组，第二个从哪里复制，第三个是目标数组，第四个是从哪里开始复制，第五个是复制的长度
        System.arraycopy(src, 0, des, 2, 2);
        System.out.println(Arrays.toString(des));
        //3、currentTimeMillis,当前时间，从1970-01-01开始统计
        Long starttime = 0L;
        starttime = System.currentTimeMillis();
        //4、gc，垃圾运行回收机制,回收不再被程序使用的内存资源，以避免内存泄漏和提高程序的性能,不一定会执行
        System.gc();

    }
}
