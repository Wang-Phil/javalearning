package meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class findcount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int max = 1;
        int[] ans = new int[num];
        for(int i = 0; i < num; i++){
            ans[i] = in.nextInt();
            max = Math.max(max, ans[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int allCount = max * (max + 1) / 2;
        for(int i = 0; i < num - 1; i++){
            if(ans[i] >= ans[i+1]){
                if(map.containsKey(ans[i])){
                    map.put(ans[i], Math.max(ans[i+1], map.get(ans[i])));
                }else{
                    map.put(ans[i], ans[i+1]);
                }
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == entry.getKey()) {
                allCount += entry.getKey() - 1;
            }else{
                allCount += entry.getValue();
            }
        }
        System.out.println(allCount);
    }
}
