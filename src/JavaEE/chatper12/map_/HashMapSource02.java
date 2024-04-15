package JavaEE.chatper12.map_;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HashMapSource02 {
    public static void main(String[] args) {
        //HashMap的扩容机制，树化模拟
        Map hashMap = new HashMap();
        for(int i = 0; i < 12; i++){
            hashMap.put(i,i+1);
        }
        hashMap.put(12, 13);
        for(int i = 13; i < 24; i++){
            hashMap.put(i,i+1);
        }
        hashMap.put(24, 25);
        for(int i = 25; i < 48; i++){
            hashMap.put(i,i+1);
        }
        hashMap.put(48, 49);
        for(int i = 49; i < 96; i++){
            hashMap.put(i,i+1);
        }
        hashMap.put(96, 97);
    }
}
