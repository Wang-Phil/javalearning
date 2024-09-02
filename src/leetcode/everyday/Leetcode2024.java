package leetcode.everyday;

/**
 * @version 1.0
 * @Author: WangWeicheng
 * @Date: 2024/9/2
 * @Time: 9:41
 **/
public class Leetcode2024 {
    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTTFF", 2));
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        //双指针解法
        return Math.max(maxConsecutive(answerKey, k, 'T'), maxConsecutive(answerKey, k, 'F'));
    }

    private static int maxConsecutive(String answerKey, int k, Character ch){
        int left = 0;
        int right = 0;
        int n = answerKey.length();
        int sumDiff = 0;
        int ans = 0;
        while(right < n){
            if(answerKey.charAt(right++) != ch) sumDiff++;
            while(sumDiff > k){
                if(answerKey.charAt(left) != ch) sumDiff--;
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
