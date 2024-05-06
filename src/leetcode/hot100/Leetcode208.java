package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/6
 *@Time: 11:03
 */

public class Leetcode208 {
    public static void main(String[] args) {

    }
}
class Trie {
    //前缀树定义
    boolean isEnd;
    Trie[] children;
    //前缀树初始化
    public Trie() {
        isEnd = false;
        children = new Trie[26];
    }
    //插入一个字符串
    public void insert(String word) {
        Trie trie = this;                           //从根节点进行创建和判断是否存在
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (trie.children[c - 'a'] == null) {   //如果为空就创建新的节点，不是空就跳过，存在了
                trie.children[c - 'a'] = new Trie();
            }
            trie = trie.children[c - 'a'];
        }
        trie.isEnd = true;                          //将最后一个节点作为结束标记，置为true
    }
    //查找一个字符串
    public boolean search(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (trie.children[c - 'a'] == null) {       //如果没找到，就是空
                return false;
            }
            trie = trie.children[c - 'a'];
        }
        return trie.isEnd;          //顺序匹配了，但是长度可能不一样，这时候就需要判断isend，如果isend是true了，那才是真的字符串
    }
    //前缀匹配，和查找一样，只不过是不需要判断最后一个字符串了
    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (trie.children[c - 'a'] == null) {       //如果没找到，就是空
                return false;
            }
            trie = trie.children[c - 'a'];
        }
        return true;
    }
}