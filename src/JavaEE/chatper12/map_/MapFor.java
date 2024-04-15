package JavaEE.chatper12.map_;

import java.util.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class MapFor {
    public static void main(String[] args) {
        //keyset，获取所有的键
        //values，获取所有的值
        //entryset，获取所有的键值对
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        //第一组：取出所有的key，然后通过get方法获取value，遍历方式为增强for循环和迭代器
        Set keyset = map.keySet();
        //1、增强for循环
        for(Object key : keyset){
            System.out.println(key+"-"+map.get(key));
        }
        //2、迭代器
        Iterator iterator = keyset.iterator();
        while(iterator.hasNext()){
            Object key = iterator.next();
            System.out.println(key+"-"+map.get(key));
        }

        //第二组：把所有的values取出来，遍历所有的values，但是无法获取key
        Collection values = map.values();
        //1、增强for循环
        for(Object value : keyset){
            System.out.println(value);
        }
        //2、迭代器
        iterator = values.iterator();
        while(iterator.hasNext()){
            Object value = iterator.next();
            System.out.println(value);
        }

        //第三组：使用EntrySet，然后使用entry的getKey和getValue方法
        Set entrySet = map.entrySet();
        //1、增强for循环
        for(Object entry : entrySet){
            Map.Entry mentry = (Map.Entry)entry;        //向下转型
            System.out.println(mentry.getKey()+"-"+mentry.getValue());
        }
        //2、迭代器
        iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry mentry = (Map.Entry)iterator.next();  //向下转型
            System.out.println(mentry.getKey()+"-"+mentry.getValue());
        }

    }

}
