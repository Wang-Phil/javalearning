package leetcode.krahets;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/5/28
 *@Time: 10:01
 */

public class Leetcode86 {
    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        ListNode bigDummy = new ListNode(0);
        ListNode smallDummy = new ListNode(0);
        ListNode big = bigDummy;
        ListNode small = smallDummy;
        while (head != null) {
            if(head.val < x) {
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigDummy.next;
        big.next = null;
        return smallDummy.next;

    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }