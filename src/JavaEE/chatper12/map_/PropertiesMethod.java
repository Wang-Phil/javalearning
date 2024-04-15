package JavaEE.chatper12.map_;

import java.util.Properties;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class PropertiesMethod {
    public static void main(String[] args) {
        Properties properties = new Properties();
        //properties.put(null, "abc");//抛出 空指针异常
        //properties.put("abc", null); //抛出 空指针异常
        properties.put("john", 100);//k-v
        properties.put("lucy", 100);
        properties.put("lic", 100);
        properties.put("lic", 88);//如果有相同的key ， value 被替换
        System.out.println("properties=" + properties);
        properties.remove("lic");       //删除
        System.out.println(properties.get("lucy"));     //查找
    }
}
