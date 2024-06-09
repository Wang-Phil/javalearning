package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/24
 *@Time: 13:27
 */

import java.util.List;

public class Leetcode206 {
    public static void main(String[] args) {

    }

/*    //1、采用头插法可以实现逆序
    public ListNode reverseList(ListNode head) {
        //反转链表
        ListNode newhead = new ListNode(0);
        newhead.next = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null) {
            next = cur.next;
            cur.next = newhead.next;
            newhead.next = cur;
            cur = next;
        }
        return newhead.next;
    }*/

    //2、采用递归也可以实现逆序
    public ListNode reverseList(ListNode head) {
        //反转链表
        return reverseNode(head, null);
    }

    public static ListNode reverseNode(ListNode cur, ListNode pre) {
        if(cur == null) return pre;     //注意，这里当cur为空的时候，pre指向的是最后一个节点，也就是反转过后的头结点，需要保存并返回
        ListNode head = reverseNode(cur.next, cur);     //这里head一直是最后一个节点
        cur.next = pre;                 //修改指针指向
        return head;                    //返回头结点
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}