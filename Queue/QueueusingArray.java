import java.util.*;
public class QueueusingArray {
    public static class Queue {
        static int arr[], size, rear;
        public Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }
        boolean isEmpty(){
            return rear == -1;
        }
        void add(int data){
            if(rear == size-1){
                System.out.println("Queue is full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }
        int remove(){
            if(isEmpty())
                return -1;
            int val = arr[0];
            for(int i=0; i<rear; i++)
                arr[i] = arr[i+1];
            rear = rear - 1;
            return val;
        }
        int peek(){
            if(isEmpty())
                return -1;
            return arr[0];
        }
    }
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       Queue q = new Queue(5);
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