package JavaEE.chatper12.set_;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HashSetSource {
    public static void main(String[] args) {
        Set set = new HashSet();

        for (int i = 0; i < 7; i++) {
            set.add(new B(10));
        }

        for (int i = 0; i < 12; i++) {
            set.add(new A(10));
        }
    }
}

class A{
    private int n;

    public A(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}

class B{
    private int n;

    public B(int n) {
        this.n = n;
    }

    @Override
    public int hashCode() {
        return 200;
    }
}
