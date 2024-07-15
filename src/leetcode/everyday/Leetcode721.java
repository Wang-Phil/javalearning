package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/15
 *@Time: 10:30
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。

现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。

合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。
 */

import java.util.*;

public class Leetcode721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();      //邮箱和姓名的对应关系
        Map<String, Integer> emailToIndex = new HashMap<>();    //邮箱和索引之间对应的关系
        int emailCount = 0;                                     //邮箱的总数量

        //遍历邮箱，加入到前面的两个map当中
        //给每个邮箱进行编号，方便后序的合并
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for(int i = 1; i < size; i++) {
                String email = account.get(i);
                if(!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailCount++);
                    emailToName.put(email, name);
                }
            }
        }

        //并查集
        DisjointSet disjointSet = new DisjointSet(emailCount);
        //建立并查集，每个邮箱都有一个序号，按照序号进行合并，这时候就已经按照题目要求进行合并了
        for(List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String email = account.get(i);
                int index = emailToIndex.get(email);
                disjointSet.union(firstIndex, index);
            }
        }
        //遍历所有邮箱，将其按照根节点，划分为不同list
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for(String email : emailToIndex.keySet()) {
            int index = disjointSet.find(emailToIndex.get(email));
            List<String> emails = indexToEmails.getOrDefault(index, new ArrayList<>());
            emails.add(email);
            indexToEmails.put(index, emails);
        }

        //将name和email合并到一起
        List<List<String>> result = new ArrayList<>();
        for(List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> accout = new ArrayList<String>();
            accout.add(name);
            accout.addAll(emails);
            result.add(accout);
        }
        return result;
    }
}

class DisjointSet{
    int parent[];
    int size[];

    //初始化并查集
    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    //查找元素所属的集合
    public int find(int x) {
        if(parent[x] != x){
            //路径压缩
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    //合并两个集合
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if(xRoot != yRoot){//按秩合并
            if(size[xRoot] < size[yRoot]){
                parent[xRoot] = yRoot;
                size[xRoot] += size[xRoot];
            }else{
                parent[yRoot] = xRoot;
                size[yRoot] += size[yRoot];
            }
        }
    }

    //获取集合的大小
    public int getSize(int x) {
        return size[find(x)];
    }
}
