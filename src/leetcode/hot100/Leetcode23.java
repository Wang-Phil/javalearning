package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/28
 *@Time: 11:31
 * 给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */

import java.util.PriorityQueue;

public class Leetcode23 {
    public static void main(String[] args) {

    }


/*    //优先队列，先把头结点放进去，然后把小的拿出来，将下一个节点放进去
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {//先将所有链表的头结点放到优先队列当中
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        return head.next;
    }*/

    public ListNode mergeKLists(ListNode[] lists) {
        //合并k个有序链表，采用分治的思想
        return mergeLists(lists, 0, lists.length);//左闭右开
    }

    public ListNode mergeLists(ListNode[] lists, int start, int end) {
        int len = end - start;
        if(len == 0) return null;
        if(len == 1) return lists[start];
        ListNode left = mergeLists(lists, start, start + len / 2);
        ListNode right = mergeLists(lists, start + len / 2, end);
        return mergeTwoLists(left, right);

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
