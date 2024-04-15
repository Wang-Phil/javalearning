package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode225 {
    //队列实现栈，两个队列实现栈的基本操作，比如栈的push，pop，emtpy，top
    //分为两个队列实现的方式和一个队列实现的方式。
    //两个队列实现时，重点是考虑什么时候进行将数据从一个队列进入到另外一个队列
    //当涉及push操作，而且queue2队列为空的时候就需要进行queue1->queue2的入栈
        public static void main(String[] args) {

            String[] list = {

                    "5oiR5Lus5p",

                    "yf5b6F5LiO",

                    "5LyY56eA55",

                    "qE5L2g5p2l",

                    "5YWx5ZCM5o",

                    "mT6YCg77ya",

                    "DQrkuK3lm7",

                    "3mlbDlrZfl",

                    "ubPlj7ANCu",

                    "iCv+eYpOWF",

                    "qOeXheeoi+",

                    "euoeeQhuaV",

                    "sOWtl+WMlu",

                    "W5s+WPsA0K",

                    "6IKd55eF57",

                    "K+57uG5YyW",

                    "566h55CG5p",

                    "Ww5a2X6Kej",

                    "5Yaz5pa55q",

                    "GI"

            };
            System.out.println("Please decode and find the answers:");

            String concatenatedString = String.join("", list);

            System.out.println(concatenatedString);


    }
}
