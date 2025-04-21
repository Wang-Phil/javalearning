package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode1534 {
    public static void main(StrJingDong[] args) {
        System.out.println(countGoodTriplets(new int[]{3,0,1,1,9,7},7,2,3));
    }
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        //暴力解法
        int ans = 0, len = arr.length;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                for(int k = j + 1; k < len; k++){
                    if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[k] - arr[j]) <= b && Math.abs(arr[k] -arr[i]) <= c)
                        ans++;
                }
            }
        }
        return ans;
    }
}
