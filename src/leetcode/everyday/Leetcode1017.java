package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/28
 *@Time: 9:42
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 */

public class Leetcode1017 {
    public static void main(String[] args) {

    }

    public String baseNeg2(int n) {
        //直接模拟
        if(n == 0 || n == 1) return String.valueOf(n);
        int k = -2;
        StringBuilder ans = new StringBuilder();
        while(n != 0){
            int remainder = n%k;
            //1、余数为负数的时候，需要加上-k保证为正数
            ans.insert(0, remainder < 0 ? -k + remainder : remainder);
            //2、然后将n进行转换,如果remain是负数的话，就是加上了-k，那么就需要加上k进行抵消，进行下一次的计算，也就是商+1
            //比如： 3 = （-2）^2 + (-2)^1 + (-2)^0，由于一次方的时候，进行了减，所以要加上2，两者之差（2-（-2）)刚好是4，也就是下一位
            n = remainder < 0 ? n / k + 1 : n / k;
        }
        return ans.toString();
    }
}
