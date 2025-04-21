package meituan;

import java.util.Scanner;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class stringformat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int num = in.nextInt();
        String[] ans = new String[num];
        for(int i = 0; i < num; i++){
            String string = in.next();
            char[] str = string.toCharArray();
            int len = str.length;
            if(isAllUpper(str)){
                ans[i] = "VIP";
            }else if(str.length < 2){
                ans[i] = "Invalid";
            }
            else if(str[0] == 'E' && str[1] == 'X') {
                int flag = 0;
                for (int j = 2; j < len; j++) {
                    // 假如存在不是全部是数字的
                    if (!Character.isDigit(str[j])) {
                        ans[i] = "Invalid";
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0){
                    ans[i] = "Express";
                }
            }else if(str[0] == 'S' && str[1] == 'T'){
                int flag = 0;
                for (int j = 2; j < len; j++) {
                    // 假如存在不是是数字的或者字母得
                    if (!(Character.isDigit(str[j]) || Character.isLetter(str[j]))) {
                        ans[i] = "Invalid";
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) ans[i] = "Standard";
            } else{
                int cntNum = 0;
                int cntCh = 0;
                int flag = 0;
                for (int j = 0; j < len; j++) {
                    // 假如存在不是是数字的或者字母得
                    if (!(Character.isDigit(str[j]) ||  Character.isLetter(str[j]))) {
                        ans[i] = "Invalid";
                        flag = 1;
                        break;
                    }
                    if(Character.isDigit(str[j])){
                        cntNum++;
                    }else{
                        cntCh++;
                    }
                }
                if(cntCh > 0 && cntNum >= 3 && flag ==0){
                    ans[i] = "Normal";
                }else{
                    ans[i] = "Invalid";
                }
            }
        }
        for(String s : ans){
            System.out.println(s);
        }
        //EX 开头后面全是数字，是 Express
        //ST 开头后面字母和数字的组合 是 Standard
        //全是大写字母  VIP
        //数字和小写字母，至少包含三个数字 Normal
        //其他情况 Invalid
    }

    private static boolean isAllUpper(char[] s){
        for(char ch : s){
            if(!Character.isUpperCase(ch)){
                return false;
            }
        }
        return true;
    }
}
