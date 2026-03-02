import java.util.*;
public class DeletionDLL {
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
    public static int size = 0;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
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
        head.prev = null;
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
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    public static int deleteMiddle(int idx) {
        if(idx == 0) {
            int val = deleteFirst();
            return val;
        }
        Node temp = head;
        for(int i=0; i<idx; i++)
            temp = temp.next;
        int val = temp.data;
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
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