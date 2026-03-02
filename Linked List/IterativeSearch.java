import java.util.*;
public class IterativeSearch {
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

    public static int search(int key) {
       Node temp = head;
       int i = 0;
       while(temp != null){
        if(temp.data == key)
            return i;
        temp = temp.next;
        i++;
       }
       return -1;
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
        System.out.println("The created linked list is: ");
        printList();
        System.out.print("Enter the number to be searched: ");
        int key = in.nextInt();
        int idx = search(key);
        if(search(key) != -1)
            System.out.print("Key found at index "+idx);
        else
            System.out.print("Key NOT found");
        in.close();
    }
}
