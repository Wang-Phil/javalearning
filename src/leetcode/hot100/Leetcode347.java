package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/14
 *@Time: 14:05
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */

import java.util.*;

public class Leetcode347 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent1(new int[]{4,1,-1,2,-1,2,3}, 2)));
    }
    //前k个高频元素
    public static int[] topKFrequent(int[] nums, int k) {
        //最小堆
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, (a,b) -> map.get(a) - map.get(b));
        for (int key : map.keySet()){
            if(pq.size()<k){
                pq.add(key);
            }else{
                if(map.get(pq.peek()) < map.get(key)){
                    pq.remove();
                    pq.add(key);
                }
            }
        }
        int [] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            res[i++] = pq.remove();
        }
        return res;
    }

    //桶排序
    public static int[] topKFrequent1(int[] nums, int k) {
        //统计频次
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length+1];
        // 遍历统计后的数字及其出现次数的映射，将每个数字根据其出现次数放入相应的桶中
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(num);
        }
        List<Integer> ans = new ArrayList<>();
        // 从出现次数最多的数字开始，依次向结果列表中添加数字，直到添加了k个或没有更多的数字
        for (int i = nums.length; i >= 0 && ans.size() < k; --i) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    ans.add(num);
                    if (ans.size() == k) {
                        break;
                    }
                }
            }
        }
        int[] res = ans.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

}
