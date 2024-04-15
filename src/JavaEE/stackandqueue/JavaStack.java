package JavaEE.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class JavaStack {
    public static void main(String[] args) {
        //栈的实现一，内置类
        //底层实现： Vector class Stack<E> extends Vector<E>
        //由于Vector支持线程同步，所以效率比较低
        Stack<Integer> stack = new Stack<>();
        stack.push(1);  //插入元素
        stack.push(2);  //插入元素
        stack.pop();    //弹出栈顶元素
        stack.peek();      //查看栈顶元素
        int n = stack.size();   //栈的大小
        System.out.println(stack.isEmpty());    //判断栈是否为空

        //栈的实现二：LinkedList
        /*LinkedList底层实现了Deque双端队列的接口，双端队列，完全可以实现栈的功能
            public class LinkedList<E>
            extends AbstractSequentialList<E>
            implements List<E>, Deque<E>,
         */
        Deque<Integer> stack2 = new LinkedList<>();
        stack2.push(1);     //插入元素
        stack2.push(2);     //插入元素
//        stack2.offer(3);    //offer和push都可以插入元素,但是push是队尾插入，offer是队首
        System.out.println(stack2);
        int m = stack2.peek();         //取栈顶元素,peek是2
        System.out.println(m);          //结果为2
        m = stack2.getFirst();          //取栈顶第一个元素
        System.out.println(m);          //结果为2
        stack2.pop();          //删除栈顶元素
    }
}
