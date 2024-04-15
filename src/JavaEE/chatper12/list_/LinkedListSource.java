package JavaEE.chatper12.list_;

import java.util.LinkedList;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class LinkedListSource {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove(1);
        linkedList.set(1,21);
        linkedList.get(1);
    }
}
