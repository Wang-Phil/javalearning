package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2864 {
    public static void main(String[] args) {
        String s = "111111111111111110000000000000010";
        System.out.println(maximumOddBinaryNumber(s));;
    }
    //最大二进制奇数
    public static String maximumOddBinaryNumber(String s) {
        //统计0-1个数，由于是奇数，最后面一个数置为1即可
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                count++;
            }

        }
        //重新构建字符串
        for (int i = 1; i < count; i++){
            stringBuilder.append("1");
        }
        for(int i = 0; i < s.length() - count; i++){
            stringBuilder.append("0");
        }
        stringBuilder.append("1");
        return stringBuilder.toString();
    }
}
