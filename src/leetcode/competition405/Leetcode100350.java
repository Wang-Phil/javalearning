package leetcode.competition405;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/7
 *@Time: 10:50
 */

import java.util.*;

public class Leetcode100350 {
    public static void main(String[] args) {
        String target = "abcdef";
        String[] words = {"abdef", "abc", "d", "def", "ef"};
        int[] costs = {100, 1, 1, 10, 5};

        System.out.println(minimumCost(target, words, costs)); // 输出: 7

        String target2 = "aaaa";
        String[] words2 = {"z", "zz", "zzz"};
        int[] costs2 = {1, 10, 100};

        System.out.println(minimumCost(target2, words2, costs2)); // 输出: -1
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        List<int[]> wordCosts = new ArrayList<>(); // 存储 [单词长度, 成本] 的列表
    }

    public static int minimumCost(String target, String[] words, int[] costs) {
        TrieNode root = new TrieNode();

        // 构建 Trie 树
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            for (char c : words[i].toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.wordCosts.add(new int[]{words[i].length(), costs[i]});
        }

        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 起始状态，空字符串的成本为0

        // 动态规划
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                node = node.children.get(target.charAt(j));
                if (node == null) break;
                for (int[] wc : node.wordCosts) {
                    int len = wc[0];
                    int cost = wc[1];
                    if (i + len <= n) {
                        dp[i + len] = Math.min(dp[i + len], dp[i] + cost);
                    }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
