package leetcode.everyday;
import java.util.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2865 {
    public static void main(String[] args) {
        Leetcode2865 leetcode2865 = new Leetcode2865();
        List<Integer> list = Arrays.asList(5,3,4,1,1);
        long num = leetcode2865.maximumSumOfHeights(list);
        System.out.println(num);
    }

    public long maximumSumOfHeights0(List<Integer> maxHeights) {
        //首先是暴力解法，枚举每个可能的山峰，然后从这个山峰出发，找到可能的值
        long maxnum = 0;
        int n = maxHeights.size();
        for(int i = 0; i < n; i++){
            long num = maxHeights.get(i);
            long minnum = num;
            for(int j = i-1; j >= 0; j--){
                minnum = Math.min(minnum, maxHeights.get(j));
                num += minnum;
            }
            minnum = maxHeights.get(i);
            for(int j = i+1; j < n; j++){
                minnum = Math.min(minnum, maxHeights.get(j));
                num += minnum;
            }
            maxnum = Math.max(maxnum, num);
        }
        return maxnum;
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        //美丽塔中高度和的最大值，单调栈，从左往右遍历数组,从右到左遍历数组，保存以num[i]为山峰的时候的最大值
        long maxnum = 0;
        int n = maxHeights.size();
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        long[] pre = new long[n], suf = new long[n];
        //前面的单调栈
        for(int i = 0; i < n; i++){
            while(!stack1.isEmpty() && maxHeights.get(stack1.peek()) > maxHeights.get(i)){
                stack1.pop();
            }
            if(stack1.isEmpty()){
                pre[i] = (long) (i+1) * maxHeights.get(i);
            }
            else {
                pre[i] = pre[stack1.peek()] + (long)(i - stack1.peek()) * maxHeights.get(i);
            }
            stack1.push(i);
        }
        //后面的单调栈
        for(int i = n-1; i >= 0; i--){
            while(!stack2.isEmpty() && maxHeights.get(stack2.peek()) > maxHeights.get(i)){
                stack2.pop();
            }
            if(stack2.isEmpty()){
                suf[i] = (long) (n-i) * maxHeights.get(i);
            }
            else {
                suf[i] = suf[stack2.peek()] + (long)(stack2.peek() - i) * maxHeights.get(i);
            }
            stack2.push(i);
            //计算最大值
            maxnum = Math.max(maxnum, pre[i] + suf[i] - maxHeights.get(i));
        }
        return maxnum;
    }
}


