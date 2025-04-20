package leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2537 {
    public static void main(String[] args) {

    }

    public long countGood(int[] nums, int k) {
        //理解思想之后，自己实现
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;
        long ans = 0;
        for(int num : nums) {
            int cur = map.getOrDefault(num, 0);
            map.put(num, cur + 1);
            count += cur;
            while(count >= k){
                int x = map.getOrDefault(nums[left], 0);
                count -= x -1;
                map.put(nums[left], x - 1);
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
