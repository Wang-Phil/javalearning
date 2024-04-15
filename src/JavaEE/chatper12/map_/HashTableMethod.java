package JavaEE.chatper12.map_;

import java.util.Hashtable;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HashTableMethod {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("no1",1);     //添加
//        hashtable.put("no1",null);  //空指针异常NullPointerException
//        hashtable.put(null,1);      //空指针异常NullPointerException
        hashtable.put("no1",2);     //替换
        hashtable.remove("no1");  //删除
        System.out.println(hashtable);

    }
}
