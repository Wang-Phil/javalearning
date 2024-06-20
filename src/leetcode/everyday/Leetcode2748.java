package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/20
 *@Time: 15:29
 * 给你一个下标从 0 开始的整数数组 nums 。如果下标对 i、j 满足 0 ≤ i < j < nums.length ，如果 nums[i] 的 第一个数字 和 nums[j] 的 最后一个数字 互质 ，则认为 nums[i] 和 nums[j] 是一组 美丽下标对 。

返回 nums 中 美丽下标对 的总数目。

对于两个整数 x 和 y ，如果不存在大于 1 的整数可以整除它们，则认为 x 和 y 互质 。换而言之，如果 gcd(x, y) == 1 ，则认为 x 和 y 互质，其中 gcd(x, y) 是 x 和 y 的 最大公因数 。
 */

public class Leetcode2748 {
    public static void main(String[] args) {

    }
    //美丽下标对的数目
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            while(nums[i] >= 10){
                nums[i] /= 10;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if(isPrime(nums[i], nums[j] % 10)) {
                    count++;
                }
            }
        }
        return count;
    }

    //判断是否互质
    private boolean isPrime(int num1, int num2) {
        //辗转相除法求最大公因数，如果最大公因数是1，则说明两个数字互质
        if(num1 < num2){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        //辗转相除法
        int c = num1 % num2;
        while(c != 0){
            num1 = num2;
            num2 = c;
            c = num1 % num2;
        }
        return num2 == 1;
    }
}
