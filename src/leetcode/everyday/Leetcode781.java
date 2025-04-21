package leetcode.everyday;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

public class Leetcode781 {
    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{0,1,0,2,0,1,0,2,1,1}));
    }
    //将其存在hashMap当中
    public static int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : answers){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(num == 0) ans += count;
            else if(count <= num + 1){
                ans += (num + 1);
            }else {
                ans += count / (num + 1) * (num + 1);
                if(count % (num + 1) != 0){
                    ans += (num + 1);
                }
            }
        }
        return ans;
    }
}
