package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/24
 *@Time: 10:41
 * 给你一个字符串 s，找到 s 中最长的 回文子串
。
 */

public class Leetcode5 {
    public static void main(String[] args) {

    }
    //最长的回文子串
    public String longestPalindrome(String s) {
        //第一种方法是中心扩散算法
        if(s.length() < 2) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            //有两种中心进行扩散
            int[] first = isPalindrome(s, i, i);
            int[] second = isPalindrome(s, i, i + 1);
            //对其进行更新
            if(first[1] - first[0] > end - start){
                start = first[0];
                end = first[1];
            }
            if(second[1] - second[0] > end - start){
                start = second[0];
                end = second[1];
            }
        }
        return s.substring(start, end + 1);
    }

    //判断是否是回文串
    public int[] isPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left+1, right-1};
    }

    //最长的回文子串
    public String longestPalindrome1(String s) {
        //第二种方法是动态规划
        if(s == null || s.length() < 2) return s;
        int start = 0, end = 0, len = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int r = 1; r < s.length(); r++) {
            for(int l = 0; l < r; l++) {
                if(s.charAt(l) == s.charAt(r) && (r- l <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if(r - l + 1 > len) {
                        len = r - l + 1;
                        start = l;
                        end = r;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
