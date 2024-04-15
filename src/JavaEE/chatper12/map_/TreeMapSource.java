package JavaEE.chatper12.map_;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class TreeMapSource {
    public static void main(String[] args) {
        //无参构造器，不会有序
        //加入一个比较器的构造器，可以有序
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照自己本身字符串的比较函数进行比较
//                return ((String) o2).compareTo((String) o1);
                //按照长度进行比较
                return ((String) o2).length() - ((String) o1).length();
            }
        });
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("kristina", "克瑞斯提诺");
        treeMap.put("smith", "斯密斯");
        treeMap.put("hsp", "韩顺平");//按照长度比较的话，加入不了，覆盖了“汤姆”的值
        System.out.println("treemap=" + treeMap);
    }
}
