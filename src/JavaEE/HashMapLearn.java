package JavaEE;

import java.util.*;

public class HashMapLearn {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //hash表使用方法，这里是hashmap
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        //插入 put(键，值）
        map.put(2,1);
        System.out.println(map);

        //查找 get(键)
        int value =  map.get(2);
        System.out.println(value);

        //删除
        map.remove(2);
        System.out.println(map);

        //检查是否存在
        map.containsKey(2);
        System.out.println( map.containsKey(2));

        //判断是否为空
        map.isEmpty();
        System.out.println(map.isEmpty());

        //求hash表个数
        int n = map.size();
        System.out.println(map.size());

        //清空hashmap
        map.clear();

        //Hashset使用方法,不是键值对形式，但是可以去重
        HashSet<Integer> set = new HashSet<Integer>();

        //添加元素
        set.add(4);

        //删除元素
        set.remove(4);

        //判断是否存在
        set.contains(4);

        //清空set
        set.clear();

        //获取元素大小
        set.size();


        //可变长数组的申请
        ArrayList<Integer> list =  new ArrayList<Integer>();
        list.add(4);

    }
}
