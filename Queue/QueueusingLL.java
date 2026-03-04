import java.util.*;
public class QueueusingLL {
    public static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class Queue {
        static Node head = null;
        static Node tail = null;

        boolean isEmpty(){
            return head == null && tail == null;
        }
        void add(int data){
            Node newNode = new Node(data);
            if(isEmpty())
                head = tail = newNode;
            tail.next = newNode;
            tail = newNode;
        }
        int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int val = head.data;
            if(head == tail)
                head = tail = null;
            else
                head = head.next;
            return val;    
        }
        int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       Queue q = new Queue();
       System.out.println("Enter 5 elements: ");
        for(int i=0; i<5; i++){
            int n = in.nextInt();
            q.add(n);
        }
        System.out.println("Element to be deleted: " + q.remove());
        System.out.println("Topmost element: " + q.peek());
        System.out.println("Current queue: ");
        while(! q.isEmpty()){
            System.out.println(q.remove());
        }
       in.close(); 
    }
}
