package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2834 {
    public static void main(String[] args) {
        //找出美丽数组的最小和
        //三个条件，第一个数组长度，第二个每个nums数组中元素互不相同，第三个不存在两个不同下标的nums[i]+nums[j] = target
        //返回数组之和，要最小
        int ans = minimumPossibleSum(5, 6);
        System.out.println(ans);
    }

    public static int minimumPossibleSum(int n, int target) {
        long ans = 0;
        int mod = 1000000007;
        int mid = target/2;
        if(n <= mid){
            for (int i = 1; i <= n; i++) {
                ans += i;
                ans = ans % mod;
            }
            return (int)ans;
        }
        else{
            //求前半部分
            for (int i = 1; i < mid; i++) {
                ans += i;
                ans %= mod;
            }
            //求后半部分
            for (int i = 0; i <= n - mid; i++) {
                ans += target+i;
                ans %= mod;
            }
        }
        return (int) ans;
    }
}
