package JavaEE.chapter11.Array01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ArrayBubble {
    public static void main(String[] args) {
        int arr[] = {1, 4, -9, 0, 10, 6};
        bubbledSort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer)o1;
                int i2 = (Integer)o2;
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(arr));

    }
    public static void bubbledSort(int[] arr, Comparator c){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(c.compare(arr[j], arr[j+1]) > 0){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =  temp;
                }
            }
        }
    }
}
