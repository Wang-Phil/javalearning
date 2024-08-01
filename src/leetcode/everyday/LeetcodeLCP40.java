package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/8/1
 *@Time: 15:51
 * 「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。 给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。
 */

import java.util.*;

public class LeetcodeLCP40 {
    public static void main(String[] args) {
        System.out.println(maxmiumScore(new int[]{2,2,2,2}, 3));
    }
    //心算挑战
    public static int maxmiumScore(int[] cards, int cnt) {
        //排序
        Arrays.sort(cards);
        // 然后使用循环进行逆序
        for (int i = 0; i < cards.length / 2; i++) {
            int temp = cards[i];
            cards[i] = cards[cards.length - 1 - i];
            cards[cards.length - 1 - i] = temp;
        }
        int ans = 0;
        List<Integer> odd = new ArrayList<Integer>();
        odd.add(0);
        List<Integer> dou = new ArrayList<>();
        dou.add(0);
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] % 2 != 0) {
                odd.add(cards[i]);
            }else{
                dou.add(cards[i]);
            }
        }
        //然后计算前缀和
        for(int i = 1; i < odd.size(); i++){
            odd.set(i,odd.get(i-1)+odd.get(i));
        }
        for(int i = 1; i < dou.size(); i++){
            dou.set(i,dou.get(i-1)+dou.get(i));
        }

        int douCnt = 0;
        while(douCnt <= cnt){
            int oddCnt = cnt - douCnt;
            if(oddCnt% 2 == 1 || oddCnt >= odd.size() || douCnt >= dou.size()){
                douCnt += 1;
                continue;
            }
            ans = Math.max(ans,odd.get(oddCnt)+dou.get(douCnt));
            douCnt += 1;
        }
        return ans;
    }
}
