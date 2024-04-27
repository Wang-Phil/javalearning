package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/26
 *@Time: 11:05
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */

public class Leetcode19 {
    public static void main(String[] args) {

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //快慢指针
        ListNode dummy = new ListNode(0);   //申请一个头结点，方便后面删除头结点的时候，出现问题
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(n > 0){//慢指针先走n-1步
            slow = slow.next;
            n--;
        }
        //然后慢指针到达最后一个节点时，快指针走到了要删除节点的前一个节点
        while(slow != null && slow.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        //对fast的next节点进行删除
        fast.next = fast.next.next;
        return dummy.next;
    }
}
