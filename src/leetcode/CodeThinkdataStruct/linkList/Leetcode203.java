package leetcode.CodeThinkdataStruct.linkList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Leetcode203 {
    public static void main(String[] args) {
        // 测试数据数组
        int[] testArray = {7,7,7,7};
        // 从数组创建链表
        ListNode head = createListFrom(testArray);

        // 调用函数移除值为3的节点
        ListNode result = removeElements(head, 7);

        // 输出结果
        printList(result);
    }

    static public ListNode removeElements(ListNode head, int val) {
        ListNode newhead = new ListNode(-1, head);
        ListNode pre = newhead;
        while(pre != null && pre.next != null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }
            //加else是为了防止连续好几个需要删除的数字出现
            else {
                pre = pre.next;
            }
        }
        return newhead.next;
    }

    // 从数组创建链表的辅助方法
    static ListNode createListFrom(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode current = head;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
        return head;
    }

    // 辅助方法，用于打印链表
    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
