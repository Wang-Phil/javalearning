package leetcode.everyday;


import java.util.HashSet;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class StrJingDong {
    public static void main(String[] args) {
        //字符串，无重复子串
        String str = "abcbc";
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        int len = str.length();
        char ch[] = str.toCharArray();
        int left = 0, right = 0;
        while(right < len){
            while(set.contains(ch[right])){
                set.remove(ch[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            set.add(ch[right]);
            right++;
        }
        System.out.println(ans);

    }
}
