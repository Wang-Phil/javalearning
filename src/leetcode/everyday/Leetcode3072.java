package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/5
 *@Time: 10:24
 * 给你一个下标从 1 开始、长度为 n 的整数数组 nums 。

现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。

你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：

如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr1 。
如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr2 。
如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元素数量较少的数组中。
如果仍然相等，那么将 nums[i] 追加到 arr1 。
连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。

返回整数数组 result 。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode3072 {
    public static void main(String[] args) {

    }
    //将元素分配到两个数组中||
    public int[] resultArray(int[] nums) {
        //树状数组
        int[] sorted = nums.clone();
        Arrays.sort(sorted);        //只进行排序，不进行去重
        int n = sorted.length;

        List<Integer> a = new ArrayList<>();        //两个数组
        List<Integer> b = new ArrayList<>();
        a.add(nums[0]);             //初始先将两个元素加入到数组当中
        b.add(nums[1]);
        //初始化两个树状数组，下标都是从1开始的，所以长度+1
        Fenwick t1 = new Fenwick(n+1);
        Fenwick t2 = new Fenwick(n+1);
        t1.add(Arrays.binarySearch(sorted, nums[0])+1);     //先将两个元素的下标放入到两个树状数组中
        t2.add(Arrays.binarySearch(sorted, nums[1])+1);

        for(int i = 2; i < n; i++) {
            int x = nums[i];
            int v = Arrays.binarySearch(sorted, x)+1;   //找到下标位置
            int gc1 = a.size() - t1.prev(v);
            int gc2 = b.size() - t2.prev(v);
            if(gc1 > gc2 || gc1 == gc2 && a.size() <= b.size()) {
                a.add(x);
                t1.add(v);
            }   else{
                b.add(x);
                t2.add(v);
            }
        }
        a.addAll(b);
        for(int i = 0; i < n; i++){
            nums[i] = a.get(i);
        }
        return nums;
    }
}

// class树状数组，定义
class Fenwick{
    private final int[] tree;

    public Fenwick(int n) {
        tree  = new int[n];
    }

    //把下标为i的元素增加1
    public void add(int i){
        while(i < tree.length){
            tree[i] = tree[i] + 1;
            i += i & -i;
        }
    }

    //返回下标在[1,i]的元素之和
    public int prev(int i){
        int res = 0;
        while(i > 0){
            res += tree[i];
            i &= i - 1;
        }
        return res;
    }
}