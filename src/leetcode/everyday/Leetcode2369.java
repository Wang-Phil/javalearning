package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2369 {
    public static void main(String[] args) {
        Leetcode2369 leetcode2369 = new Leetcode2369();
        boolean out = leetcode2369.validPartition(new int[]{4, 5, 6,4,4});
        System.out.println("结果是"+out);
    }

    public boolean validPartition(int[] nums) {
        //没想到是动态规划
        //dp数组定义，dp[i]表示前面i个元素是否存在一个有效的划分
        boolean f[] = new boolean[nums.length+1];
        //初始化dp数组
        f[0] = true;
        //状态转移方程
        for(int i = 1; i < nums.length; i++){
                f[i+1] = f[i-1] && nums[i-1] == nums[i];
                if(i > 1){
                    boolean state1 = nums[i-1] == nums[i-2] && nums[i-1] == nums[i];
                    boolean state2 = nums[i-1] == nums[i-2] + 1 && nums[i-1] + 1 == nums[i];
                    f[i+1] = f[i+1] || f[i-2] && (state1 || state2);
            }
        }
        return f[nums.length];
    }
}


