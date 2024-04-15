package JavaEE.chapter15.properties_;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //使用Properties类来读取mysql.properties文件
        //1、创建Properties对象
        Properties properties = new Properties();
        //2、加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //3、把k-v显示到控制台
        properties.list(System.out);
        //4、根据key获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名："+user);
        System.out.println("密码："+pwd);

        //使用Properties 类来创建 配置文件, 修改配置文件内容
        //创建
        //1.如果该文件没有key 就是创建
        //2.如果该文件有key ,就是修改
        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "汤姆");//注意保存时，是中文的 unicode 码值
        properties.setProperty("pwd", "888888");
        //将k-v 存储文件中即可
        properties.store(new FileOutputStream("src\\mysql2.properties"), null); //comments表示是注释
        System.out.println("保存配置文件成功~");
    }
}
