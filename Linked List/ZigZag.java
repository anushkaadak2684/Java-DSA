import java.util.*;
public class ZigZag {
    public static class Node {
        int data;
        Node next;
        public Node (int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    
    public static void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static Node findMidNode(){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void zigzag() {
        if(head == null || head.next == null)
            return;

        Node midNode = findMidNode();
        Node curr = midNode.next;
        midNode.next = null;

        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;
        
        Node tempLeft;
        Node tempRight;

        while(left != null && right != null){
            tempLeft = left.next;
            left.next = right;
            tempRight = right.next;
            right.next = tempLeft;
            left = tempLeft;
            right = tempRight;
        }

    }

    public static void printList() {
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter 5 digits to add in the end: ");
        for(int i=0; i<5; i++){
            int n = in.nextInt();
            addLast(n);
        }
        System.out.println("Created Linked List: ");
        printList();
        zigzag();
        System.out.println("ZigZag Linked List: ");
        printList();
        in.close();
    }
}
