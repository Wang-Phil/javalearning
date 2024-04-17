package leetcode.hot100;
/*
 *Author: [WangWeicheng]
 *Date: 2024/4/16
 *Time: 15:03
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 */

public class Leetcode76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        String s = "ADOBECODEBANC";
    }

   /* public static String minWindow(String s, String t) {
        //解法一的时间复杂度为O（52m+n),m为s的长度，n为t的长度
        //滑动窗口题目。
        //整体思路为：先将子串t加入到hash表中，然后遍历s的子串。
        //如果涵盖了，就遍历左边界，让其不涵盖。
        //采用ascll码进行hash表的表示，128位
        int hasht[] = new int[128];
        int hashs[] = new int[128];
        int s_len = s.length();
        char arrays[] = s.toCharArray();
        int ansLeft = -1;
        int ansRight = s_len;
        int left = 0;
        //先将t的字符加入到hash表当中
        for (char c : t.toCharArray()) {
            hasht[c]++;
        }
        //遍历s字符
        for(int right = 0; right < s_len; right++){
            hashs[arrays[right]]++;
            //如果字符串确实覆盖了，就比较长度，然后取其中较小的。
            while(is_covered(hashs, hasht)){
                if(right - left  < ansRight - ansLeft){
                    ansLeft = left;
                    ansRight = right;
                }
                hashs[arrays[left++]]--;
            }
        }
        //substring是左闭右开的
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight+1);
    }

    //判断s字符是否包含t字符
    private static boolean is_covered(int[] hashs, int[] hasht){
        for (int i = 'a'; i <= 'z'; i++) {
            if(hashs[i] < hasht[i]){
                return false;
            }
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            if(hashs[i] < hasht[i]){
                return false;
            }
        }
        return true;
    }*/

   public static String minWindow(String s, String t) {
       //对思路一进行优化：怎么优化，判断是否涵盖那边进行优化。
       //增加一个变量less用来表示s的子串与t中不同字母的个数
       //如果less为0的时候，就说明两个子串出现了相同的子串
       int hasht[] = new int[128];
       int hashs[] = new int[128];
       int s_len = s.length();
       char arrays[] = s.toCharArray();
       int ansLeft = -1;
       int ansRight = s_len;
       int left = 0;
       int less = 0;
       //先将t的字符加入到hash表当中
       for (char c : t.toCharArray()) {
           if(hasht[c] == 0) less++;
           hasht[c]++;
       }
       //遍历s字符
       for(int right = 0; right < s_len; right++){
           char c = arrays[right];
           hashs[c]++;
           if(hashs[c] == hasht[c]) less--;     //如果两个字符出现的次数相同了，就说明当前的字母不同个数少了
           //如果字符串确实覆盖了，就比较长度，然后取其中较小的。
           while(less == 0){
               if(right - left  < ansRight - ansLeft){
                   ansLeft = left;
                   ansRight = right;
               }
               char x = arrays[left++];
//               hashs[x]--;
               if(hashs[x]-- == hasht[x]) less++;       //这里只需要执行一次，改成小于的话，会执行多次。
           }
       }
       //substring是左闭右开的
       return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight+1);
   }
}
