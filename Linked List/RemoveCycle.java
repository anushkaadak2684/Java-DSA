import java.util.*;
public class RemoveCycle {
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

    public static boolean isCycle(){
        if(head == null || head.next == null)
            return false;

        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void removeCycle(){
        boolean cycle = false;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false)
            return;

        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
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
        tail.next = head.next;
        if(isCycle())
            System.out.println("Cycle detected in the list");
        else
            System.out.println("No cycle detected in the list");
        removeCycle();
        System.out.println("After removing cycle.....");
        System.out.println("Testing function gives result: " + isCycle());
        in.close();
    }
}


