package leetcode.hot100;
/*
 *@version 1.0
 *@Author: WangWeicheng
 *@Date: 2024/4/29
 *@Time: 11:00
 */

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer, DLinkedNode> map = new HashMap<>();
    private int capacity;
    private int size;
    DLinkedNode head;       //这里的头结点和尾结点都是虚拟节点，方便删除
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();   //构建只有两两个虚拟节点的头结点和尾结点
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {//不存在直接返回-1
            return -1;
        }
        //存在的话，返回关键字的值
        DLinkedNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        //首先判断存在不存在
        if(!map.containsKey(key)) {//不存在直接加入到链表头，同时加入到hash表当中
            DLinkedNode node = new DLinkedNode(key, value);
            map.put(key, node);
            addToHead(node);
            size += 1;
            if(size > capacity) {
                DLinkedNode tail = removeTail();
                System.out.println(tail.key + " " + tail.value);
                map.remove(tail.key);
                size -= 1;
            }
        }
        else{//存在，更改值，之后，移动到头部
            DLinkedNode node = map.get(key);
            node.value = value;
            moveToHead(node);
        }
    }
    //增加到头结点中
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    //删除节点和增加节点分开
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    //移动到头结点可以分为删除节点然后增加节点
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
    //删除尾结点，就是获取到尾结点的前一个节点，进行删除
    private DLinkedNode removeTail() {//这里需要返回节点，是因为还要在hash表中删除对应的键值对
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }
}
