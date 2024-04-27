package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/25
 *@Time: 9:54
 * 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为
回文链表
。如果是，返回 true ；否则，返回 false 。
 */

import java.util.ArrayList;
import java.util.List;

public class Leetcode234 {
    public static void main(String[] args) {

    }

/*    //首先是暴力解法，先将链表存储在数组中，然后再判断
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }*/

    //接下来是快慢指针解法，快指针走两步，慢指针走一步，快指针到了终点之后，慢指针就走了一半，然后再来一个指针进行比较
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;      //特殊情况判断
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){//快指针走两步，慢指针走一步，注意循环结束条件
            slow = slow.next;
            fast = fast.next.next;
        }
        //对后半段的链表进行逆转，逆转之后就可以直接判断了
        ListNode reversed = reverseList(slow, null);
        //接下来快指针指向head，进行回文判断
        ListNode p1 = reversed;
        ListNode p2 = head;
        while(p1 != null && p2 != null){
            if(p1.val != p2.val){//一旦值不相等，就说明不是回文串
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    //反转链表
    public ListNode reverseList(ListNode cur, ListNode pre){
        if(cur == null){ return pre; }
        ListNode head = reverseList(cur.next, cur);
        cur.next = pre;
        return head;
    }
}
