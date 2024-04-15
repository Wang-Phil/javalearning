package JavaEE.chapter11.homework11;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HomeWork01 {
    public static void main(String[] args) {
        //字符串部分反转
        String s = "abcdef";
        char[] chars = s.toCharArray();
        int left = 1, right = 4;
        while(left < right){
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        s = new String(chars);
        System.out.println(chars);
    }
}
