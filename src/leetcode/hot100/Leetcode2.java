package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/26
 *@Time: 10:57
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头
 */

public class Leetcode2 {
    //两数相加
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //两数相加，注意进位，要重新申请一个新的节点
        int carry = 0;//当前节点之和
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(carry % 10);
            carry /= 10;
            cur = cur.next;
        }
        //可能存在最后一个数字，没有加到链表当中
        if(carry != 0){
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
