package JavaEE.chatper12.map_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class MapSource {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1",123);
        //结构：Set<Map.Entry<K, V>> entrySet();
        Set set = map.entrySet();
        System.out.println(set.getClass());         //HashMap$EntrySet
        for(Object entry :set){
            System.out.println(entry.getClass());   //HashMap$Node
            //向下转型Object->Map.Entry
            Map.Entry entry1 = (Map.Entry)entry;
            System.out.println("entry1.getKey(): "+entry1.getKey() +"   entry1.getValue():  " + entry1.getValue());
        }
    }
}
