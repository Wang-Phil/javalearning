package leetcode.competition404;

public class Leetcode100340 {
    public static void main(String[] args) {
        System.out.println(maxHeight(2, 4)); // 示例 1
        System.out.println(maxHeight(2, 1)); // 示例 2
        System.out.println(maxHeight(1, 1)); // 示例 3
        System.out.println(maxHeight(10, 1)); // 示例 4
    }


    public static int maxHeight(int red, int blue) {
        // 尝试从红色开始
        int heightFromRed = calculateHeight(red, blue, true);
        // 尝试从蓝色开始
        int heightFromBlue = calculateHeight(red, blue, false);
        // 返回最大高度
        return Math.max(heightFromRed, heightFromBlue);
    }

    public static int calculateHeight(int red, int blue, boolean startWithRed) {
        int height = 0;
        boolean isRed = startWithRed;

        while (true) {
            height++;
            int ballsNeeded = height;

            if (isRed) {
                if (red >= ballsNeeded) {
                    red -= ballsNeeded;
                } else {
                    break;
                }
            } else {
                if (blue >= ballsNeeded) {
                    blue -= ballsNeeded;
                } else {
                    break;
                }
            }

            isRed = !isRed;  // 切换颜色
        }

        return height - 1;  // 返回最大的有效高度
    }

}