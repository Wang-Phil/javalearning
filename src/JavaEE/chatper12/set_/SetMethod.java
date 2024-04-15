package JavaEE.chatper12.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class SetMethod {
    public static void main(String[] args) {
        Set set = new HashSet();
        for (int i = 0; i < 10; i++) {
            set.add(i+3);
        }
        set.add(null);
        set.add(null);

        //遍历方式
        //第一种方式，迭代器的方式
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //第二种方式，采用增强for循环
        for(Object o : set){
            System.out.println("o:"+o);
        }
    }
}
