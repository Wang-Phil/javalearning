package JavaEE.chatper12.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("张三丰");
        list.add("潘小青");
        list.add(1,"邹昊飞");  //在index = 1的地方插入
        list.set(1,"明星");       //在指定index插入设置元素
        list.get(1);            //获取下标为1的元素
        list.remove(1);    //删除下标为1的元素

        List list1 = new ArrayList();
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add("hello");
        list1.add(2,"韩顺平教育");
        System.out.println(list1.get(4));
        list1.remove(6);
        list1.set(6,"nihao");
        Iterator iterator = list1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
