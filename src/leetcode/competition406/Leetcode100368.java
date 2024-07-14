package leetcode.competition406;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/7/14
 *@Time: 10:35
 * 给你一个整数数组 nums 和一个链表的头节点 head。从链表中移除所有存在于 nums 中的节点后，返回修改后的链表的头节点。
 */

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode100368 {
    public static void main(String[] args) {

    }
    //从链表中移除在数组中存在的节点
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode newhead = new ListNode(0,head);
        ListNode cur = newhead;
        //加入set
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //遍历链表，如果存在就删除
        while(cur != null && cur.next != null) {
            int num = cur.next.val;
            while(set.contains(num)) {
                cur.next = cur.next.next;
                num = cur.next.val;
            }
            cur = cur.next;
        }
        return newhead.next;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }