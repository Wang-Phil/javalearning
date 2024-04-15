package JavaEE.chatper12.collection_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Collection01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("滴滴");
        list.add(true);
        list.add(10);   //存放的是对象，Integer（10）
        list.remove(1); //删除对应下标元素
        list.remove(true);  //删除指定元素
        list.contains("jack");
        list.size();
        list.isEmpty();
        list.addAll(new ArrayList<>(Arrays.asList("shu","sho","sho")));
    }
}
