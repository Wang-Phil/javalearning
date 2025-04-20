package leetcode.everyday;

public class Leetcode2843 {

    public static void main(String[] args) {

    }

    public int countSymmetricIntegers(int low, int high) {
        //暴力解法，枚举
        int cnt = 0;
        for(int i = low; i <= high; i++) {
            char ch[] = Integer.toString(i).toCharArray();
            if(ch.length % 2 != 0) continue;
            int num = 0;
            for(int j = 0; j < ch.length/2; j++) {
                num += ch[j] - '0';
            }
            for(int j = ch.length/2; j < ch.length; j++){
                num -= ch[j] - '0';
            }
            if(num == 0) cnt++;
        }
        return cnt;

    }

}
