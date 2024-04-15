package JavaEE.chatper12.set_;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class LinkedHashSetSource {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(456);
        linkedHashSet.add(456);
        linkedHashSet.add(new String("wwc"));
        System.out.println(linkedHashSet.size());

    }
}
