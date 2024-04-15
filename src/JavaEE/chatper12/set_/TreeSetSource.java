package JavaEE.chatper12.set_;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class TreeSetSource {
    public static void main(String[] args) {
        //无参构造器无序，需要重新定义一个比较器（匿名内部类）
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//                return ((String)o1).compareTo((String)o2);
                //自定义比较函数，如果比较函数中两个值相同，就默认这两个元素相同，不会加入到Set当中
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        treeSet.add("wwc");     //底层是TreeMap
        treeSet.add("liujie");
        treeSet.add("luoxiang");
        treeSet.add("hanjie");  //如果是比较长度的话，这个与liujie长度相同，不会加入到treeSet中
        System.out.println(treeSet);
    }
}
