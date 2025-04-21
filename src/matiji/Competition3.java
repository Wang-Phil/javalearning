package matiji;

import java.util.*;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Competition3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // code here
        int n = input.nextInt();
        int m = input.nextInt();
        List<Set<Integer>> lists = new ArrayList<>();
        //原始集合
        Set<Integer> nums = new HashSet();
        for (int i = 0; i < n; i++) {
            nums.add(i+1);
        }
        for(int i = 0; i < m; i++){
            int num1 = input.nextInt();
            if(nums.contains(num1)){
                nums.remove(num1);
            }
            int num2 = input.nextInt();
            if(nums.contains(num2)){
                nums.remove(num2);
            }
            if(lists.size() > 0){
                int j = 0;
                for(; j < lists.size(); j++){
                    Set temp = lists.get(j);
                    if(temp.contains(num1)){
                        temp.add(num2);
                        break;
                    }
                    else if(temp.contains(num2)){
                        temp.add(num1);
                        break;
                    }
                }
                if(j == lists.size()){
                    Set newSet = new HashSet<>();
                    newSet.add(num1);
                    newSet.add(num2);
                    lists.add(newSet);
                }
            }else{
                Set newSet = new HashSet<>();
                newSet.add(num1);
                newSet.add(num2);
                lists.add(newSet);

            }
        }
        //获取总共的集合数量,其中的元素个数就是集合个数
        int[] ans = new int[nums.size()+lists.size()];
        for(int i = 0; i < nums.size(); i++){
            ans[i] = 1;
        }
        int size = nums.size();
        for(int i = 0; i < lists.size(); i++){
            int cnt = lists.get(i).size();
            ans[i + size] = cnt;
        }
        //现在有从小到大的数组，将其分为两组，两组之积最大
        // 1  9 50  99 100
        //180*110 || 170*120
        // 1 1 1 1 4
        //1 2 6 100
        //首先应该求和，然后尽量达到一半的时候是之积是最大的
        int left = 0;
        int right = 0;
        int i = 0;
        while(i < ans.length){
            if(left <= right){
                left += ans[i++];
            }else{
                right += ans[i++];
            }
        }
        System.out.println(left * right);
        input.close();
    }
}
