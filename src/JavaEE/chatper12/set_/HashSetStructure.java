package JavaEE.chatper12.set_;

/**
 * @version 1.0
 * @auther wangweicheng
 */
public class HashSetStructure {
    public static void main(String[] args) {
        Node[] nodes = new Node[16];
        Node jack = new Node("jack", null);
        nodes[2] = jack;
        Node jack1 = new Node("jack1", null);
        nodes[2].next = jack1;
        Node jack2 = new Node("jack2", null);
        jack1.next = jack2;
        Node luck = new Node("luck", null);
        nodes[3] = luck;

    }
}

class Node{
    String name;
    Node next;

    public Node(String name, Node node) {
        this.name = name;
        this.next = node;
    }
}
