import java.util.*;
public class QueueusingStack {
    public static class Queue {
        Stack <Integer> s1 = new Stack<>();
        Stack <Integer> s2 = new Stack<>();
        boolean isEmpty(){
            return s1.isEmpty();
        }
        void add(int data){
            while(!isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }
        int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
    }
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       Queue q = new Queue();
       System.out.println("Enter 5 elements: ");
        for(int i=0; i<5; i++){
            int n = in.nextInt();
            q.add(n);
        }
        System.out.println("Current Queue:");
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        in.close();
    }
  }
}
