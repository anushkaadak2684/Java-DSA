import java.util.*;
public class StackusingQueueII {
    public static class Stack {
        Queue <Integer> q1 = new LinkedList<>();
        Queue <Integer> q2 = new LinkedList<>();
        boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        void push(int data){
            if(!q1.isEmpty()){
                q2.add(data);
                while(!q1.isEmpty())
                    q2.add(q1.remove());
            }
            else{
                q1.add(data);
                while(!q2.isEmpty())
                    q1.add(q2.remove());
            }
        }
        int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            else{
                if(!q1.isEmpty())
                    return q1.remove();
                else
                    return q2.remove();
            }
        }
        int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            else{
                if(!q1.isEmpty())
                    return q1.peek();
                else
                    return q2.peek();
            }
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
        System.out.println("Current Stack:");
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        in.close();
    }
}
