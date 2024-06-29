package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/6/29
 *@Time: 20:09
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 */

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode297 {
    public static void main(String[] args) {

    }
}
//二叉树的序列化和反序列化
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //层次遍历实现
        if(root == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null){
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }else{
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.append("]").toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //反序列化
        if(data.equals("[]")) return null;
        String[] tokens = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 1;
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!tokens[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(tokens[i]));
                queue.add(node.left);
            }
            i++;
            if(!tokens[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(tokens[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
