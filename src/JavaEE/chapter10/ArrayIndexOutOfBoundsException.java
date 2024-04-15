package JavaEE.chapter10;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        int a[] = new int[]{1,2};
        for (int i = 0; i < 3; i++) {
            System.out.println(a[i]);
        }
    }
}
