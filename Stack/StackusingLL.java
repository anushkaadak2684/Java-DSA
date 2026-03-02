import java.util.*;
public class StackusingLL {
    public static class Stack {
        public class Node {
            int data;
            Node next;
            public Node(int data){
                this.data = data;
                this.next = null;
            }
        }
        Node head;

        boolean isEmpty(){
            if(head == null)
                return true;
            return false;
        }
        void push(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        int pop(){
            if(isEmpty())
                return -1;
            int val = head.data;
            head = head.next;
            return val;
        }
        int peek(){
            if(isEmpty())
                return -1;
            return head.data;
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack s = new Stack();
        System.out.println("Enter 5 elements: ");
        for(int i=0; i<5; i++){
            int n = in.nextInt();
            s.push(n);
        }
        System.out.println("Element to be deleted: " + s.pop());
        System.out.println("Topmost element: " + s.peek());
        System.out.println("Current stack: ");
        while(! s.isEmpty()){
            System.out.println(s.pop());
        }
        in.close();
    }
}
