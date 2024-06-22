package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Test {
    public static void main(String[] args) {
        String[] strings = {""};
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        //统计各个字符出现的次数
        for(String string : strings){
            if(hashMap.containsKey(string)){
                int count = hashMap.get(string) + 1;
                hashMap.put(string, count);
            }
            else{
                hashMap.put(string, 1);
            }
        }
//        //寻找topK前三的字符
//        Arrays<String, Integer> arrays[] = new Arrays<String, Integer>();
//        Arrays.sort(arrays, new Comparator<Arrays<String, Integer>>() {
//            @Override
//            public int compare(Arrays<String, Integer> o1, Arrays<String, Integer> o2) {
//                int i1 = (int)o1
//                return 0;
//            }
//        })
        //失败


    }
}
