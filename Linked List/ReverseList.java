import java.util.*;
public class ReverseList {
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

    public static void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
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
        System.out.print("The created linked list is: ");
        printList();
        reverse();
        System.out.print("The reversed linked list is: ");
        printList();
        in.close();
    }
}
