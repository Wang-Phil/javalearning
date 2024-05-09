package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/9
 *@Time: 9:24
 */

public class Leetcode2105 {
    public static void main(String[] args) {
        System.out.println(minimumRefill(new int[]{1,2,4,4,5}, 6, 5));
    }
    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int sum = 0;
        int left = 0, right = n - 1;
        int waterA = capacityA;
        int waterB = capacityB;

        while(left < right){
            //水不够了，都需要回去加水
            if(waterA < plants[left]){
                waterA = capacityA;
                sum++;
            }
            if(waterB < plants[right]){
                waterB = capacityB;
                sum++;
            }
            waterA -= plants[left];
            waterB -= plants[right];
            left++;
            right--;
        }
        if(left == right && waterA < plants[left] && waterB < plants[right]){
                sum++;
        }
        return sum;
    }

}
