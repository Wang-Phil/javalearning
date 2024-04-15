package JavaEE.chatper12.map_;

import java.util.HashMap;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HashMapSource {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("java", 10);//ok
        map.put("php", 10);//ok
        map.put("java", 20);//替换value
        System.out.println("map=" + map);
    }
}
