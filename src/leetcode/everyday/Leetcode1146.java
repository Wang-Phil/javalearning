package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/26
 *@Time: 9:58
 */

import java.util.*;

public class Leetcode1146 {
    public static void main(String[] args) {

    }
}
class SnapshotArray {
    Map<Integer, List<int[]>> map = new HashMap<>();
    int snapId = 0;
    //初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
    public SnapshotArray(int length) {
    }
    // 会将指定索引 index 处的元素设置为 val
    public void set(int index, int val) {
        //从map中获取元素，如果不存在，就新增一个
        map.computeIfAbsent(index, k -> new ArrayList<>()).add(new int[]{snapId, val});
    }
    // 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
    public int snap() {
        return snapId++;
    }
    //根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
    public int get(int index, int snap_id) {
        if(!map.containsKey(index)) {
            return 0;       //不存在
        }
        List<int[]> list = map.get(index);
        int j = search(list, snap_id);
        return j < 0 ? 0 : list.get(j)[1];

    }

    private int search(List<int[]> h, int x) {
        //闭区间
        int left = 0, right = h.size() - 1;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if(h.get(mid)[0] <= x) {
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return left-1;
    }
}