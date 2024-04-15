package leetcode.everyday;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class Leetcode2765 {
    public static void main(String[] args) {
        Leetcode2765 leetcode2765 = new Leetcode2765();
        leetcode2765.alternatingSubarray(new int[]{4,5,6,5,6});
    }

    public int alternatingSubarray(int[] nums) {
        //交替子数组,初步思想，分组，第一个while循环用来遍历数组，第二个循环用来寻找可能的最大长度。
        int left = 0;
        int maxLen = -1;
        int i = 0;
        while(i < nums.length - 1){
            if(nums[i+1] - nums[i] != 1){
                i++;
                continue;
            }
            left = i;
            i += 2;
            while(i < nums.length && nums[i] == nums[i-2]){
                i++;
            }
            maxLen = Math.max(maxLen, i - left);
            i--;    //要进行回退一下，起始位置可能是前面结束的最后一个位置
        }
        System.out.println(maxLen);
        return maxLen;
    }
}


