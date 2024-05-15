package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/15
 *@Time: 9:39
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
//数据流的中位数
class MedianFinder {
    //两个堆，一个小跟堆，一个大根堆，小跟堆存储最大的N/2个数，大根堆存储最小的N/2个数
    PriorityQueue<Integer> minHeap,maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b)->(b-a));
    }
    //具体设定一个规则，如果两个堆大小不一样，就插入到A中，如果大小不一样，就插入到B中
    public void addNum(int num) {
        //
        if(maxHeap.size() != minHeap.size()){
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        return minHeap.size() != maxHeap.size() ? minHeap.peek() : (maxHeap.peek()+minHeap.peek())/2.0;
    }
}