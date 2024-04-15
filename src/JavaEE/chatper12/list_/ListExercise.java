package JavaEE.chatper12.list_;

import java.util.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        List list1 = new LinkedList();
        List list2 = new Vector();

        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 19));
        list.add(new Book("三国", "罗贯中", 80));
//        list.add(new Book("西游记", "吴承恩", 10));

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        sort(list);
        for(Object book : list){
            System.out.println(book.toString());
        }
    }
    public static void sort(List list){
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                Book book1 = (Book)list.get(j);
                Book book2 = (Book)list.get(j+1);
                if(book1.getPrice() < book2.getPrice()){
                    list.set(j,book2);
                    list.set(j+1,book1);
                }
            }
        }
    }
}

class Book{
    private String name;
    private int price;
    private String writer;
    //自动生成类get，set方法，以及构造器快捷键

    public Book(String name, String writer, int price) {
        this.name = name;
        this.price = price;
        this.writer = writer;
    }

    public int getPrice() {
        return price;
    }

    public String getWriter() {
        return writer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", writer='" + writer + '\'' +
                '}';
    }
}
