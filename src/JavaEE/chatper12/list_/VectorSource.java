package JavaEE.chatper12.list_;

import java.util.Vector;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class VectorSource {
    public static void main(String[] args) {
        Vector vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(11);
    }
}
