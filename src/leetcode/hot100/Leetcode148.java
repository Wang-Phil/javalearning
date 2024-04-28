package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/27
 *@Time: 11:08
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */

public class Leetcode148 {
    public static void main(String[] args) {

    }
/*    //直接插入排序，找到插入位置，然后进行插入
    public ListNode sortList(ListNode head) {
        ListNode newhead = new ListNode(0);
        newhead.next = null;
        ListNode p = head;
        while(p != null){//超出时间限制，需要nlogn时间复杂度
            ListNode findNode = newhead;
            ListNode nextp = p.next;        //保存下一个节点，用来遍历
            while(findNode.next != null && findNode.next.val < p.val){//找到插入位置
                findNode = findNode.next;
            }
            p.next = findNode.next;
            findNode.next = p;
            p = nextp;

        }
        return newhead.next;
    }*/

    //链表的归并排序，时间复杂度为nlogn
    public ListNode sortList(ListNode head) {
        return TwoRoadMergeNode(head);
    }

    ListNode TwoRoadMergeNode(ListNode head){
        //递归出口
        if(head == null || head.next == null) return head;  //只有一个节点，不用排序
        ListNode fast = head.next;                  //注意节点初始化，如果是奇数个节点，slow指向最中间的节点
        ListNode slow = head;                       //如果是偶数个节点，slow指向中间靠左的那个节点
        while(fast != null && fast.next != null){//递归找到中间节点
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;               //断开成为两条链进行合并
        slow.next = null;
        ListNode left = TwoRoadMergeNode(head); //继续递归找中间节点
        ListNode right = TwoRoadMergeNode(mid);
        return Merge_Node(left, right);         //合并后返回
    }

    ListNode Merge_Node(ListNode head1, ListNode head2){//合并两个有序链表
        ListNode newhead = new ListNode(0);
        newhead.next = null;
        ListNode p = newhead;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                p.next = head1;
                head1 = head1.next;
            }
            else{
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if(head1 != null) p.next = head1;
        if(head2 != null) p.next = head2;
        return newhead.next;
    }
}
