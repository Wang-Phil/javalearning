package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/4
 *@Time: 14:20
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。

例如 arr = [2,3,4] 的中位数是 3 。
例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
实现 MedianFinder 类:

MedianFinder() 初始化 MedianFinder 对象。

void addNum(int num) 将数据流中的整数 num 添加到数据结构中。

double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 */

import java.util.PriorityQueue;

public class Leetcode295 {
    public static void main(String[] args) {

    }
}
//数据六的中位数
class MedianFinder {
    //两个堆，一个大根堆，一个小跟堆,小跟堆里面存放最大的n/2个数，大根堆里面存放n/2的n个数
    PriorityQueue<Integer> minHeap,maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->b-a);
    }
    //具体规则就是，当小跟堆与大根堆的数量不相等的时候，就先放在小跟堆堆中，如果大小一样，就放在大根堆中
    //这样的话，首先刚开始都会放在大根堆中，然后转移到小跟堆，但是一旦数量不相等的时候，先放在小跟堆，然后转移到大根堆
    //为什么不直接放呢？因为还不知道他的大小
    public void addNum(int num) {
        if(minHeap.size()!=maxHeap.size()){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            return minHeap.peek();
        }else{      //注意这里要除以分数，转换为浮点数运算
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
    }
}