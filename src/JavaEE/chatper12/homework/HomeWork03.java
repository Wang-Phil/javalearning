package JavaEE.chatper12.homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork03 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack",650);
        map.put("tom",1200);
        map.put("smith",2900);
        map.put("jack",2600);
        Set entrySet = map.entrySet();
        //获取到所有key
        Set keyset = map.keySet();
        for(Object key : keyset){
            map.put(key, (int)map.get(key) + 100);
        }
        for (Object o : entrySet){
            Map.Entry mentry = (Map.Entry)o;
            System.out.println(mentry.getKey()+"-"+mentry.getValue());
        }
        Collection collection = map.values();
        for(Object o : collection){
            System.out.println(o);
        }


    }
}
