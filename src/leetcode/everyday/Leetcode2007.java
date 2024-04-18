package leetcode.everyday;
/*
 *Author: [WangWeicheng]
 *Date: 2024/4/18
 *Time: 10:12
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
 */

import java.util.*;

public class Leetcode2007 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1,2,2,4,4,8})));
    }
/*    public static int[] findOriginalArray(int[] changed) {
        //找到原数组，采用排序+hash表，从大到小遍历
        int n = changed.length;
        int ans[] = new int[n/2];
        int ans_index = 0;
        //如果元素个数不是偶数倍，说明不是双倍数组
        if(n % 2 != 0) return new int[0];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Arrays.sort(changed);
        for (int x : changed) {
            if(!hashMap.containsKey(x)) {//如果这个数不包含的话，说明是原数组中的元素
                if(ans_index == ans.length){
                    return new int[0];
                }
                ans[ans_index++] = x;
                //将2x放到hashmap当中
                hashMap.merge(2*x, 1, Integer::sum);

            }
            else{//如果这个数已经存在hashmap当中了，就说明，他不是原数组的元素
                int c = hashMap.merge(x,-1, Integer::sum);
                //如果这个数不存在了，从hashmap中移除。
                if(c == 0){
                    hashMap.remove(x);
                }
            }
        }
        return ans;
    }*/
/*    public static int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        int ans[] = new int[n/2];
        int ans_index = 0;
        //如果元素个数不是偶数倍，说明不是双倍数组
        if(n % 2 != 0) return new int[0];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Arrays.sort(changed);
        for (int x : changed) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }
        for(int x : changed){
            if(hashMap.get(x)==0){      //如果找不到，就继续往下找
                continue;
            }
            //长度不符
            if(ans_index == ans.length) return new int[0];
            ans[ans_index++] = x;       //从小到大，找到了，就是原数组的值
            //删除hash表中的元素
            hashMap.merge(x, -1, Integer :: sum);
            //如果其二倍元素不存在，说明也不是这个数组
            if(hashMap.getOrDefault(2*x,0)==0) return new int[0];
            hashMap.merge(2*x, -1, Integer:: sum);
        }
        return ans;
    }*/

    public static int[] findOriginalArray(int[] changed) {
        //使用数组模拟hash表，减少时间复杂度,而且还可以在遍历的过程中删除对应的数
        int n = changed.length;
        int ans[] = new int[n/2];
        int ans_index = 0;
        //如果元素个数不是偶数倍，说明不是双倍数组
        if(n % 2 != 0) return new int[0];
        int max = 0;
        //找到最大值
        for(int x : changed) if(x > max) max = x;
        int cnt[] = new int[max+1];
        //将所有元素放到数组hash中
        for(int x : changed){
            cnt[x]++;
        }
        //遍历数组
        int j = 0;
        for (int i = 0; i <= max && ans_index < n/2; i++) {
            if(cnt[i] > 0){
                j = i << 1;
                if(j > max || cnt[j] < cnt[i]) return new int[0];
                cnt[j] -= cnt[i];
                for (int k = 0; k < cnt[i]; k++) {
                    ans[ans_index++] = i;
                }
            }
        }
        return ans;
    }
}
