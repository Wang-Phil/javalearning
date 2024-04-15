package JavaEE.stackandqueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class JavaQueue {
    public static void main(String[] args) {
//        //使用LinkedList实现队列
//        Queue<Integer> queue = new LinkedList<>();
//        // 添加元素到队列尾部
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//        // 获取队列头部元素并删除
//        int head = queue.poll();
//        System.out.println("Head of the queue: " + head);
//        // 获取队列头部元素但不删除
//        int peek = queue.peek();
//        System.out.println("Peek of the queue: " + peek);
//        // 遍历队列中的元素
//        System.out.println("Elements in the queue: ");
//        for (Integer element : queue) {
//            System.out.println(element);
//        }


        //使用ArrayQueue实现队列
        Queue<Integer> queue = new ArrayDeque<>();

        // 添加元素到队列尾部
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        // 获取队列头部元素并删除
        int head = queue.poll();
        System.out.println("Head of the queue: " + head);

        // 获取队列头部元素但不删除
        int peek = queue.peek();
        System.out.println("Peek of the queue: " + peek);

        // 遍历队列中的元素
        System.out.println("Elements in the queue: ");
        for (Integer element : queue) {
            System.out.println(element);
        }
    }
}
