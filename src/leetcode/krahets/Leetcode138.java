package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/30
 *@Time: 9:40
 */

public class Leetcode138 {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {       //先复制一个链表
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {//构建新节点的random指向
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //拆分链表
        cur = head.next;
        Node pre = head, res = head.next;
       while(cur.next != null){
           pre.next = pre.next.next;
           cur.next = cur.next.next;
           pre = pre.next;
           cur = cur.next;
       }
       pre.next = null;
       return res;
    }
}
class Node{
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}