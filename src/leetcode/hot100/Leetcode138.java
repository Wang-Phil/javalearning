package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/27
 *@Time: 10:28
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。

构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。

例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。

返回复制链表的头节点。

用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
你的代码 只 接受原链表的头节点 head 作为传入参数。


 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode138 {
    public static void main(String[] args) {

    }
/*    //方法1：采用hash表实现
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //采用hash表进行，直接根据hash表的
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        //首先创建新的节点，不制定指向
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        //然后根据在map中的指向，给新的节点构造指向
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }*/
    //方法2：对在原来的链表进行操作
public Node copyRandomList(Node head) {
    if(head == null) return null;
    //1、先复制链表
    Node cur = head;
    while(cur != null){
        Node temp = new Node(cur.val);
        temp.next = cur.next;
        cur.next = temp;
        cur = cur.next.next;
    }
    //2、然后更新新的节点的random指向
    cur = head;
    while(cur != null){
        if(cur.random != null){
            cur.next.random = cur.random.next;
        }
        cur = cur.next.next;
    }
    //3、重新构建新的需要返回的链表
    cur = head;
    Node newHead = head.next;
    Node newcur = head.next;
    while(newcur.next != null){
        cur.next = cur.next.next;
        newcur.next = newcur.next.next;
        cur = cur.next;
        newcur = newcur.next;
    }
    cur.next = null;   //最后一个节点空指针指向需要重新赋值
    return newHead;

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
