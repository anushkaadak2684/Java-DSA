import java.util.*;
public class CircularQusingArray {
    public static class Queue {
        static int arr[], size, rear, front;
        public Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        boolean isFull(){
            return (rear + 1) % size == front;
        }
        void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            if(front == -1)
                front = 0;
            rear = (rear + 1) % size;
            arr[rear] = data;
        }
        int remove(){
            if(isEmpty())
                return -1;
            int val = arr[front];
            if(rear == front){
                rear = front = -1;
            }
            else{
                front = (front + 1) % size;
            }
            return val;
        }
        int peek(){
            if(isEmpty())
                return -1;
            return arr[front];
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
        System.out.println("2 elements to be deleted: ");
        for(int i=0; i<2; i++){
            System.out.print(q.remove() + " ");
        }
        System.out.print("Add 2 more elements to be inserted: ");
        for(int i=0; i<2; i++){
            int n = in.nextInt();
            q.add(n);
        }
        System.out.println("Topmost element: " + q.peek());
        System.out.println("Current queue: ");
        while(! q.isEmpty()){
            System.out.println(q.remove());
        }
       in.close(); 
    }
}