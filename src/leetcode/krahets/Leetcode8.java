package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/17
 *@Time: 15:49
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数。

函数 myAtoi(string s) 的算法如下：

空格：读入字符串并丢弃无用的前导空格（" "）
符号：检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。如果两者都不存在，则假定结果为正。
转换：通过跳过前置零来读取该整数，直到遇到非数字字符或到达字符串的结尾。如果没有读取数字，则结果为0。
舍入：如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被舍入为 −231 ，大于 231 − 1 的整数应该被舍入为 231 − 1 。
返回整数作为最终结果。
 */

public class Leetcode8 {
    public static void main(String[] args) {

    }
    //字符串转换为整数
    public int myAtoi(String s) {
        //删除前面空格
        char[] chars = s.trim().toCharArray();
        if(chars.length == 0) return 0;
        //判断前置是正数还是负数，使用sign进行标记，同时配置起步下表
        int i = 0;
        int sign = 1;
        if(chars[0]=='-'){
            i = 1;
            sign = -1;
        }else if(chars[0]=='+'){
            i=1;
        }
        //binary用来判断下次的值是否会越界
        int ans = 0, binary = Integer.MAX_VALUE/10;
        //遍历字符串
        for(int j = i; j < chars.length; j++){
            //遇到不符合的直接break
            if(chars[j] < '0' || chars[j] > '9'){ break;}
            //判断是否越界
            if(ans > binary || ans == binary && chars[j] > '7'){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //执行乘法操作
            ans = ans * 10 + chars[j] - '0';
        }
        return sign * ans;
    }
}
