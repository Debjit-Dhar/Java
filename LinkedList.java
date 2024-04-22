import java.io.*;

class Node {
    private int data;
    private Node link;

    Node(int data) {
        this.data = data;
        this.link = null;
    }
    Node(Node node){
        this.data=node.data;
        this.link=node.link;
    }
    final Node getLink(){
        return this.link;
    }
    boolean emptyL(Node head){
        return head==null;
    }

    boolean atendL(Node cur) {
        return cur.link == null;
    }

    void insertFront(Node head, Node target) {
        target.link = head.link;
        head.link = target;
    }

    void insertAfter(Node prev, Node target) {
        target.link = prev.link;
        prev.link = target;
    }

    Node deleteFront(Node head) {
        return head.link;
    }

    void deleteAfter(Node cur) {
        if (!atendL(cur)) {
            cur.link = cur.link.link;
        }
    }

    void display(Node head) {
        Node cur = new Node(head);
        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.link;
        }
        System.out.println();
    }
}

public class LinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d;
        System.out.println("Enter data");
        d=Integer.parseInt(br.readLine());

        // Creating an empty linked list
        Node head = new Node(d);

        // Example usage of Node methods
        System.out.println("Enter data");
        d=Integer.parseInt(br.readLine());
        Node node1 = new Node(d);
        System.out.println("Enter data");
        d=Integer.parseInt(br.readLine());
        Node node2 = new Node(d);
        System.out.println("Enter data");
        d=Integer.parseInt(br.readLine());
        Node node3 = new Node(d);

        head.insertFront(head, node1);
        head.insertAfter(node1, node2);
        head.insertAfter(node2, node3);

        System.out.println("Initial Linked List:");
        head.display(head);

        // Perform some operations (you can customize based on your requirements)
        System.out.println("Enter data");
        d=Integer.parseInt(br.readLine());
        Node newNode = new Node(d);
        head.insertFront(head, newNode);

        Node prevNode = head.getLink();
        System.out.println("Enter data");
        d=Integer.parseInt(br.readLine());
        Node newNodeAfterPrev = new Node(d);
        head.insertAfter(prevNode, newNodeAfterPrev);

        System.out.println("Linked List after insertions:");
        head.display(head);

        head=head.deleteFront(head);
        head.deleteAfter(head);

        System.out.println("Linked List after deletions:");
        head.display(head);
    }
}
