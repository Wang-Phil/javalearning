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
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}