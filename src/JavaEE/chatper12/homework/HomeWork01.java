package JavaEE.chatper12.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork01 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊破千万l。多少分老妇女大宽带，1动画片对数");
        News news2 = new News("男子突然想起来2个月前钓的鱼,sjoad顶级大佬大概多少分大红豆");
        List list = new ArrayList<>();
        list.add(news1);
        list.add(news2);
        for(int i = list.size() - 1; i >= 0; i--){
            News news = (News)list.get(i);
            String name = news.getName();
            if(name.length() > 15){
                name = name.substring(0,15);
                name = name + "...";
                news.setName(name);
            }
            System.out.println(((News)list.get(i)).getName());
        }
    }
}

class News{
    private String name;
    private String content;

    public News(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "name='" + name +  '\'' +
                '}';
    }
}
