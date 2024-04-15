package JavaEE.chapter11.Array01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class ArraysExercise {
    public static void main(String[] args) {
        book[] books = new book[4];
        books[0] = new book("红楼梦", 23);
        books[1] = new book("西游记", 30);
        books[2] = new book("水浒传", 18);
        books[3] = new book("三国演义", 12);
//        Arrays.sort(books);
        Arrays.sort(books, new Comparator<book>() {
            @Override
            public int compare(book o1, book o2) {
                double i1 = (double)o1.price;
                double i2 = (double)o2.price;
                return (int)(i1 - i2);
            }
        });
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].name+books[i].price);
        }

    }
}

class book{
    String name;
    double price;
    public book(String name, double price){
        this.name = name;
        this.price = price;
    }
}
