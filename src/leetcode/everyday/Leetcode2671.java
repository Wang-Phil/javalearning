package leetcode.everyday;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2671 {
    HashMap<Integer, Integer> hashmap;
    public static void main(String[] args) {

    }
    public boolean hasFrequency(int frequency) {
        ArrayList<Integer> array = (ArrayList)hashmap.values();
        Collections.sort(array);
        int left = 0;
        int right = 100000;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(array.get(mid) == frequency) return true;
            else if(array.get(mid) > frequency) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

}
