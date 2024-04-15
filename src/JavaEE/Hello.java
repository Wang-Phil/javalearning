package JavaEE;

import java.util.HashMap;
import java.util.Scanner;

public class Hello {
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
        map.size();
        System.out.println(map.size());

        int i = 0;
        System.out.print("请输入一个整数");
        if(scanner.hasNextInt()){
            i = scanner.nextInt();
            System.out.print("你输入的整数为："+i);
        }
        else{
            System.out.print("你输入的不是整数，请重新输入");
        }

    }
}
