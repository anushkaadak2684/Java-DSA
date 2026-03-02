import java.util.*;
public class Deletion {
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
    public static int size = 0;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
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

    public static int deleteFirst() {
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public static int deleteLast() {
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++)
            prev = prev.next;
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public static int deleteMiddle(int idx) {
        if(idx == 0) {
            int val = deleteFirst();
            return val;
        }
        Node prev = head;
        for(int i=0; i<idx-1; i++)
            prev = prev.next;
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 10 digits to add in the beginning: ");
        for(int i=0; i<10; i++){
            int n = in.nextInt();
            addFirst(n);
        }
        System.out.println("Current Linked List: ");
        printList();
        System.out.println("Element removed from the beginning: " + deleteFirst());
        System.out.println("Element removed from the last: " + deleteLast());
        System.out.println("Enter the index from where u want to delete: ");
        int idx = in.nextInt();
        System.out.println("Element removed from the middle: " + deleteMiddle(idx));
        System.out.println("Linked List after removing elements: ");
        printList();
        in.close();
    }
}