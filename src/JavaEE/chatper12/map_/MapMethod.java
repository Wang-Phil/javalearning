package JavaEE.chatper12.map_;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("no1","jack");  //添加
        map.put("no2","jerry");  //添加
        String  str = (String)map.get("no1"); //获取
        System.out.println(str);
        map.size();                 //map大小
        map.remove("no1");      //删除
        System.out.println(map.isEmpty());  //判断是否为空
        map.clear();            //清空
        System.out.println(map.containsKey("no2")); //判断这个键是否存在

    }
}
