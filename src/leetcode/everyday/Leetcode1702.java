package leetcode.everyday;
/**
 * @version 1.0
 * @auther wangweicheng
 * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
 * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 * 比方说， "00010" -> "10010"
 * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 * 比方说， "00010" -> "00001"
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
 */
public class Leetcode1702 {
    public static void main(String[] args) {
        System.out.println(maximumBinaryString(new String("000110")));
    }
/*
    public static String maximumBinaryString(String binary) {
        //大概就这两种变形，一种是连续的零，可以直接变成1。。0,如果不是再看是否有1010
        int n = binary.length();
        char chars[] = binary.toCharArray();
        int j = 0;
        for(int i = 0; i < n; i++){
            //找到第一个0
            if(chars[i] == '0'){
                //找到第二个0
                while(i >= j || (j < n && chars[j] == '1')){
                    j++;
                }
                //进行替换
                if(j < n){
                    chars[i] = '1';
                    chars[j] = '1';
                    chars[i+1] = '0';
                }
            }
        }
        return new String(chars);
    }

 */
    public static String maximumBinaryString(String binary) {
        int i = binary.indexOf('0');
        if(i < 0) return binary;
        int n = binary.length();
        int cnt = 0;
        for(i++; i < n; i++){//统计i到n-1中1的个数
            cnt += binary.charAt(i) - '0';
        }
        //目前只有java11才支持repeat，这里是8
//        return "1".repeat(n - 1 - cnt) + '0' + "1".repeat(cnt);
        StringBuilder stringBuilder = new StringBuilder();
        for(i = 0; i < n-1-cnt; i++) stringBuilder.append('1');
        stringBuilder.append('0');
        for(i = 0; i < cnt; i++) stringBuilder.append('1');
        return new String(stringBuilder);
    }

}

