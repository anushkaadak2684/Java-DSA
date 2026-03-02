import java.util.*;
public class InsertionDLL {
    public static class Node {
        int data;
        Node next;
        Node prev;
        public Node (int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public static void addMiddle(int data, int idx) {
        Node newNode = new Node(data);
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node temp = head;
        for(int i=0; i<idx-1; i++)
            temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
        temp.next.prev = newNode;
        newNode.prev = temp;
    }

    public static void printList() {
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 3 digits to add in the beginning: ");
        for(int i=0; i<3; i++){
            int n = in.nextInt();
            addFirst(n);
        }
        System.out.println("Enter 3 digits to add in the end: ");
        for(int i=0; i<3; i++){
            int n = in.nextInt();
            addLast(n);
        }
        System.out.println("Enter 3 digits to add in the middle alongwith their index: ");
        for(int i=0; i<3; i++){
            int n = in.nextInt();
            int idx = in.nextInt();
            addMiddle(n, idx);
        }
        System.out.println("The created linked list is: ");
        printList();
        in.close();
    }
}

