package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/26
 *@Time: 11:15
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */

import java.util.List;

public class Leetcode24 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        //如果只有一个节点或者没有节点
        if(head == null || head.next == null) return head;
        //先创建头结点
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode prep = newhead;
        ListNode curp = prep.next;
        ListNode nextp = curp.next;
        ListNode p = head;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
        while(nextp != null){
            //首先进行接链和断链
            curp.next = nextp.next;
            nextp.next = curp;
            prep.next = nextp;
            //然后进行下一次的赋值
            prep = curp;
            if(curp.next == null) break;
            curp = curp.next;
            if(curp.next == null) break;
            nextp = curp.next;
        }
        p = head;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
        return newhead.next;
    }
}
