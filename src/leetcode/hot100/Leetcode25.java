package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/27
 *@Time: 9:39
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */

public class Leetcode25 {
    public static void main(String[] args) {

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        //申请一个带头结点的链表方便操作
        ListNode newhead = new ListNode(0,head);
        //每次选k个节点进行翻转
        int count = 0;
        ListNode nexthead = newhead;     //nexthead每次保存作为下次头插法的头节点
        ListNode curr = head;           //curr用来遍历整个链表
        while(curr != null) {
            curr = curr.next;
            count++;
            if(count == k) {            //如果计数器统计到了k个，就可以进行头插法逆转链表
                ListNode p = nexthead.next;     //p指针用来遍历当前需要逆转的链表
                ListNode first = nexthead;      //用来保存第一个节点，方便逆转之后调整指针指向
                while(p != curr){
                    ListNode nextp = p.next;        //保存下一个节点，用于下次遍历
                    p.next = nexthead.next;          //头插法
                    nexthead.next = p;
                    p = nextp;                  //更新p指针
                }
                first.next = p;     //更新第一个节点的指针指向
                nexthead = first;    //更新nexthead
                count = 0;
            }
        }
        return newhead.next;
    }
}
