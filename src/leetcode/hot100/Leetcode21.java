package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/26
 *@Time: 10:51
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */

public class Leetcode21 {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //简单题，多做几遍基本就是秒解
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (list1 != null && list2 != null) {//先合并完一个链表
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }else{
                cur.next = list2;
                cur =  cur.next;
                list2 = list2.next;
            }
        }
        //然后补充剩余的部分
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }
}
