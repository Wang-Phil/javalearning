package leetcode.everyday;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/23
 *@Time: 11:38
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */

public class Leetcode160 {


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
     val = x;
      next = null;
    }
}

    public static void main(String[] args) {

    }
/*    //自己写的，逻辑大概是对的，但是就是循环判断的出口不会判断，比较麻烦。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //相交链表
        ListNode listA = headA;
        ListNode listB = headB;
        boolean flagA = true;
        boolean flagB = true;
        //循环的结束条件写什么？,不用这么麻烦。
        while (listA != null || listB != null) {
            if (listA == listB) return listA;
            if (listA == null && flagA) {
                listA = headB;
                flagA = false;
            } else if (listA == null && flagA) {
                break;
            } else {
                listA = listA.next;
            }
            if (listB == null && flagB) {
                listB = headA;
                flagB = false;
            } else if (listB == null && !flagB) {
                break;
            } else {
                listB = listB.next;
            }
        }
        return null;
    }*/

    //改进一下，循环判断的出口直接修改为两个不相等。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //相交链表
        ListNode listA = headA;
        ListNode listB = headB;
        //直接写不相等
        while (listA != listB) {
            listA = listA == null ? headB : listA.next;
            listB = listB == null ? headA : listB.next;
        }
        return listA;
    }
}
