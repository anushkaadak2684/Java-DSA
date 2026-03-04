import java.util.*;
public class QueueusingDeque {
    public static class Queue {
        Deque <Integer> dq = new LinkedList<>();
        boolean isEmpty(){
            return dq.isEmpty();
        }
        void add(int data){
                dq.addLast(data);
        }
        int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return dq.removeFirst();
        }
        int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return dq.getFirst();
        }
    }
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       Queue q = new Queue();
       System.out.print("Enter 5 elements: ");
        for(int i=0; i<5; i++){
            int n = in.nextInt();
            q.add(n);
        }
        System.out.println("Peek Element: " + q.peek());
        System.out.print("Current Queue: ");
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        in.close();
    }
}

