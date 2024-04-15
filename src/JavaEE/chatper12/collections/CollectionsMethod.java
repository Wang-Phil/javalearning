package JavaEE.chatper12.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class CollectionsMethod {
    public static void main(String[] args) {
        //创建ArrayList 集合，用于测试.
        List list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");
        list.add("tom");
        
        //1、sort(list)针对元素的顺序比较后进行排序
        Collections.sort(list);
        //2、sort(list, Comparator)添加指定的比较器进行排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //这里指定长度进行排序
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        //3、reverse(List)反转list比较
        Collections.reverse(list);
        //4、shuffle(List)随机排序
        Collections.shuffle(list);
        //5、swap(list, int, int)交换元素位置
        Collections.swap(list, 1, 3);
        System.out.println(list);

        //6、max(Collection)返回最大元素,可以添加比较器，自行设定规则，来确定最大
        System.out.println(Collections.max(list));
        Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //这里指定长度进行排序
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        //7、min参考max，方法一致
        //8、frequency(Collection, Object)统计元素出现次数
        System.out.println(Collections.frequency(list,"tom"));
        //9、copy(List dest, List src)将src中的内容复制到dest中
        List list2 = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list2.add(i);
        }
        Collections.copy(list2, list);   //list2的实际元素要比list多，不然会越界
        System.out.println(list2);
        Collections.replaceAll(list,"tom","merry");
        System.out.println(list);
    }
}
