package JavaEE.chatper12.collection_;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class CollectionIterator1 {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        //创建迭代器，进行遍历,相当于一个指针
        Iterator iterator = sites.iterator();
        while(iterator.hasNext()){
            String str = (String)iterator.next();
            System.out.println(str);
            if(str.equals("Google")){   //如果是google，删除当前元素
                iterator.remove();
            }
        }
        //进行下次遍历的时候要对迭代器进行重置
        iterator = sites.iterator();
        //另外一种遍历方式，增强for循环
        for(String str : sites){
            System.out.println(str);
        }
    }
}
