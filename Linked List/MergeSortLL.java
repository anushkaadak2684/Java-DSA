import java.util.*;
public class MergeSortLL {
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

    public static Node findMidNode(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public static Node mergeSort(Node head) {
        if(head == null || head.next == null)
            return head;

        Node midNode = findMidNode(head);
        Node rightHead = midNode.next;
        midNode.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft, newRight);
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
        System.out.println("Given Linked List: ");
        printList();
        head = mergeSort(head);
        System.out.println("Sorted Linked List: ");
        printList();
        in.close();
    }
}
