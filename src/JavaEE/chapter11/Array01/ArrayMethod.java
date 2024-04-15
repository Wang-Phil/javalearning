package JavaEE.chapter11.Array01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ArrayMethod {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4};
        //1、toString返回数组的字符串形式
        System.out.println(Arrays.toString(arr));
        //2、sort排序方法
        Integer[] arr1 = {1, -1, 7, 0, 89};
        Arrays.sort(arr1);
        //定制排序，传入两个参数，第一个是排序的数组，第二个是comparator匿名内部类
        Arrays.sort(arr1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        //3、binarySearch，二分搜索进行查找，arr必须排好序
        int index = Arrays.binarySearch(arr1, 3);
        //4、copyOf，数组的复制
        Integer[] array = Arrays.copyOf(arr1,3);
        //5、数组的填充
        Arrays.fill(array, 100);
        //6、equals，比较两个数组元素是否一致
        boolean isequal = Arrays.equals(array, arr1);
        //7、aslist 将一组转为list
        List<Integer> list = Arrays.asList(1,2,3,4);
    }
}
