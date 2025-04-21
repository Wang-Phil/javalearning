package leetcode.competition412;

/**
 * @version 1.0
 * @Author: WangWeicheng
 * @Date: 2024/8/25
 * @Time: 10:51
 * 给你一个正整数数组 nums 。
 *
 * 如果我们执行以下操作 至多一次 可以让两个整数 x 和 y 相等，那么我们称这个数对是 近似相等 的：
 *
 * 选择 x 或者 y  之一，将这个数字中的两个数位交换。
 * 请你返回 nums 中，下标 i 和 j 满足 i < j 且 nums[i] 和 nums[j] 近似相等 的数对数目。
 *
 * 注意 ，执行操作后一个整数可以有前导 0 。
 **/
public class LeetcodeQ2 {

//    public static void main(String[] args) {
//        System.out.println(countPairs(new int[]{3,30}));
//    }
//    //统计近似相等对数
//    public static int countPairs(int[] nums) {
//        //将数字转化为字符串，然后统计不同的部分
//        int n = nums.length;
//        int ans = 0;
//        for(int i = 0; i < n; i++){
//            for(int j = i + 1; j < n; j++){
//                String s1 = String.valueOf(nums[i]);
//                String s2 = String.valueOf(nums[j]);
//                if(s1.length() == s2.length() && isSimilar(s1, s2)){
//                    ans++;
//                }else if(s1.length() - s2.length() == 1 && isSimilar2(s1, s2)){
//                    ans++;
//                }else if(s2.length() - s1.length() == 1 && isSimilar2(s2, s1)){
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
//
//    private static boolean isSimilar(String s1, String s2) {
//        //判断不同的部分有多少个
//        int len = s1.length();
//        int first = -1, second = -1;
//        int diffCount = 0;
//        for(int i = 0; i < len; i++){
//            if(s1.charAt(i) != s2.charAt(i)){
//                diffCount++;
//                if(first == -1){
//                    first = i;
//                }else{
//                    second = i;
//                }
//            }
//        }
//        boolean a1 = diffCount == 0;
//        boolean a2 = diffCount == 2 &&  s1.charAt(first) == s2.charAt(second)  && s1.charAt(second) == s2.charAt(first);
//        return a1 && a2;
//    }
//
//    private static boolean isSimilar2(String s1, String s2) {
//        //默认s1长度大于s2
//        for(int i = 1; i < s1.length(); i++){
//            if(s1.charAt(i) == '0'){
//                String modified = s1.substring(1, i) + s1.charAt(0) + s1.substring(i + 1);
//                if (modified.equals(s2)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

        // 检查两个字符串是否能通过一次交换变得相等
        private static boolean canBecomeEqualByOneSwap(String a, String b) {
            int len = a.length();
            int diffCount = 0;
            int firstDiff = -1, secondDiff = -1;

            for (int i = 0; i < len; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    diffCount++;
                    if (firstDiff == -1) {
                        firstDiff = i;
                    } else {
                        secondDiff = i;
                    }
                }
            }

            if (diffCount == 0) {
                return true; // 已经相等
            } else if (diffCount == 2) {
                char[] aChars = a.toCharArray();
                char temp = aChars[firstDiff];
                aChars[firstDiff] = aChars[secondDiff];
                aChars[secondDiff] = temp;

                String swappedA = new String(aChars);
                return swappedA.equals(b);
            }

            return false;
        }

        // 检查一个长度较长的数字能否通过交换后与较短的数字相等
        private static boolean canBecomeEqualByLeadingZero(String longer, String shorter) {
            // 只考虑长度相差1的情况
            if (longer.length() - shorter.length() != 1) {
                return false;
            }

            for (int i = 0; i < longer.length(); i++) {
                if (longer.charAt(i) == '0') {
                    // 尝试将 '0' 交换到第一个位置，并移除它
                    String modified = longer.substring(0, i) + longer.substring(i + 1);
                    if (modified.equals(shorter)) {
                        return true;
                    }
                }
            }

            return false;
        }

        public static int countApproxEqualPairs(int[] nums) {
            int n = nums.length;
            int count = 0;

            // 枚举所有的数对 (nums[i], nums[j])
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    String str1 = String.valueOf(nums[i]);
                    String str2 = String.valueOf(nums[j]);

                    if (str1.length() == str2.length()) {
                        if (canBecomeEqualByOneSwap(str1, str2)) {
                            count++;
                        }
                    } else if (Math.abs(str1.length() - str2.length()) == 1) {
                        if (canBecomeEqualByLeadingZero(str1, str2) || canBecomeEqualByLeadingZero(str2, str1)) {
                            count++;
                        }
                    }
                }
            }

            return count;
        }

        public static void main(String[] args) {
            int[] nums1 = {886595,767627,6691,593887,857750,919155,830918,593887,593788,593788,660078,598873,310196,668007,597883,983587,897853,668700,435383,953887,631608,897853,953887,240754,593887,597883,455127,627877,643862,660087,893587,129173,228736,627877,775850,875750,50701,830255,751,729113,684778,114586,154186,593887,668700,238726};
            System.out.println(countApproxEqualPairs(nums1));  // 输出：?
        }

}
